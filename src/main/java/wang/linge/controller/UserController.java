package wang.linge.controller;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import wang.linge.Constant.CookieConstant;
import wang.linge.config.WechatAuthorizeUrlConfig;
import wang.linge.dto.UserDTO;
import wang.linge.enums.ExceptionEnum;
import wang.linge.exception.SubscribeException;
import wang.linge.service.SubscribeService;
import wang.linge.service.UserService;
import wang.linge.utils.CookieUtil;
import wang.linge.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by linge on 2017/11/19.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private WechatAuthorizeUrlConfig urlConfig;

    @Autowired
    private SubscribeService subscribeService;



    @GetMapping("/center")
    public ModelAndView center(@RequestParam(value = "userId",defaultValue = "") String userId,
                               HttpServletRequest request,
                               Map<String,Object> map){
        if(userId.equals("")){
            userId = CookieUtil.getCookieValue(request,CookieConstant.TOKEN);
        }
        UserDTO userDTO = service.findOne(userId);
        if(userDTO == null){
            throw new SubscribeException(ExceptionEnum.USER_NOT_EXISTENT);
        }
        map.put("userDTO",userDTO);

        Integer userTotal = subscribeService.countUserTotal(userId);
        Integer fensTotal = subscribeService.countFensTotal(userId);
        Integer followFlag = subscribeService.checkFollow(CookieUtil.getCookieValue(request, CookieConstant.TOKEN), userId);

        map.put("userTotal",userTotal);
        map.put("fensTotal",fensTotal);
        map.put("followFlag",followFlag);
        return new ModelAndView("user/member",map);
    }

    @GetMapping("/user_center")
    public ModelAndView userCenter(@RequestParam(value = "userId",defaultValue = "") String userId,
                                   HttpServletRequest request,
                                   Map<String,Object> map){
        if(userId.equals("")){
            userId = CookieUtil.getCookieValue(request,CookieConstant.TOKEN);
        }
        UserVO userVO = service.findUserCenter(CookieUtil.getCookieValue(request, CookieConstant.TOKEN), userId);
        map.put("userVO",userVO);
        return new ModelAndView("user/center",map);
    }

    @GetMapping("/login")
    public ModelAndView filterLogin(@RequestParam("openid")String openid,
                              HttpServletResponse response,
                              HttpSession session,
                              Map<String,Object> map){
        //将userId存进cookie并返回本来要访问的页面
        UserDTO userDTO = service.findOneByOpenId(openid);
        if(userDTO == null){
            throw new SubscribeException(ExceptionEnum.AUTHORIZE_FAIL);
        }

        //将token存进cookie value为userID 并设置过期时间
        CookieUtil.set(response, CookieConstant.TOKEN,userDTO.getId(),CookieConstant.EXPIRE);

        String targetUrl = (String)session.getAttribute("targetUrl");
        if(targetUrl != null){
            session.removeAttribute("targetUrl");
        }else{
            targetUrl = urlConfig.getSubscribe()+"/user/center?userId="+userDTO.getId();
        }
        return new ModelAndView("redirect:"+urlConfig.getSubscribe()+targetUrl);
    }
}
