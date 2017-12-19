package wang.linge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import wang.linge.Constant.CookieConstant;
import wang.linge.enums.FollowFlagEnum;
import wang.linge.service.SubscribeService;
import wang.linge.utils.CookieUtil;
import wang.linge.utils.ResultVOUtil;
import wang.linge.vo.ResultVO;
import wang.linge.vo.SubscribeListVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by linge on 2017/11/18.
 */
@Controller
@RequestMapping("/subscribe")
public class SubscribeController {

    @Autowired
    private SubscribeService service;

    //关注好友
    @GetMapping(value = "/follow",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResultVO follow(@RequestParam("fensId")String fensId,
                         HttpServletRequest request){
        String userId = CookieUtil.getCookieValue(request, CookieConstant.TOKEN);
        service.follow(userId,fensId);
        return ResultVOUtil.success("添加关注成功");
    }

    //取消关注
    @GetMapping(value = "/cancelFollow",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResultVO cancelFollow(@RequestParam("fensId")String fensId,
                                 HttpServletRequest request){
        String userId = CookieUtil.getCookieValue(request, CookieConstant.TOKEN);
        service.cancel(userId,fensId);
        return ResultVOUtil.success("取消关注成功");
    }

    //关注列表
    @GetMapping("/followList")
    public ModelAndView followList(@RequestParam("userId") String userId,
                                   Map<String,Object> map){
        List<SubscribeListVo> subscribeList = service.findFollow(userId);
        map.put("subscribeList",subscribeList);

        return new ModelAndView("subscribe/subscribeList",map);
    }

    //粉丝列表
    @GetMapping("/fensList")
    public ModelAndView fensList(@RequestParam("userId") String userId,
                                   Map<String,Object> map){
        List<SubscribeListVo> subscribeList = service.findFens(userId);
        map.put("subscribeList",subscribeList);

        return new ModelAndView("subscribe/subscribeList",map);
    }

    //好友列表  互相关注
    @GetMapping("/friends")
    @ResponseBody
    public List<SubscribeListVo> filterFriends(@RequestParam("userId") String userId){
        List<SubscribeListVo> mutualSubscribe = service.findMutualSubscribe(userId);
        return mutualSubscribe;
    }

    @GetMapping("/old_isFriends")
    @ResponseBody
    public Integer isFriends(@RequestParam("fensId") String fensId,
                             HttpServletRequest request){
        String userId = CookieUtil.getCookieValue(request, CookieConstant.TOKEN);
        Integer mutualFollow = service.checkMutualFollow(userId, fensId);
        if(mutualFollow == FollowFlagEnum.CONCERN.getCode()){
            return 1;
        }
        return 0;
    }

    /**
     * 根据所发的两个用户id判断是否为好友，如果是则返回-1
     * @param fensId
     * @param userId
     * @return
     */
    @GetMapping("/isFriends")
    @ResponseBody
    public Integer filterIsFriends(@RequestParam("fensId") String fensId,
                             @RequestParam("userId") String userId){
        Integer mutualFollow = service.checkMutualFollow(userId, fensId);
        if(mutualFollow == FollowFlagEnum.CONCERN.getCode()){
            return 1;
        }
        return 0;
    }
}
