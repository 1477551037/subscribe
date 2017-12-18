package wang.linge.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import wang.linge.config.WechatAuthorizeUrlConfig;
import wang.linge.exception.AuthorizeException;
import wang.linge.exception.SubscribeException;
import wang.linge.utils.ResultVOUtil;
import wang.linge.vo.ResultVO;

/**
 * Created by linge on 2017/11/21.
 */
@ControllerAdvice
public class SubscribeExceptionHandler {

    @Autowired
    private WechatAuthorizeUrlConfig urlConfig;

    @ExceptionHandler(AuthorizeException.class)
    public ModelAndView handlerAuthorizeException(){
        return new ModelAndView("redirect:"
                .concat(urlConfig.getDomainName())
                .concat(urlConfig.getPath())
                .concat("?returnUrl=")
                .concat(urlConfig.getSubscribe())
                .concat("/subscribe/user/login"));
    }

    @ExceptionHandler(SubscribeException.class)
    @ResponseBody
    public ResultVO handlerSubscribeException(SubscribeException e){
        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }
}
