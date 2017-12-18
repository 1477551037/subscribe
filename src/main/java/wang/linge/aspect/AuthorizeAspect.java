package wang.linge.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import wang.linge.Constant.CookieConstant;
import wang.linge.exception.AuthorizeException;
import wang.linge.utils.CookieUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by linge on 2017/11/21.
 */
@Aspect
@Component
@Slf4j
public class AuthorizeAspect {

    @Pointcut("execution(public * wang.linge.controller.*.*(..))" +
            "&& !execution(public * wang.linge.controller.*.filter*(..))")
    public void verify(){}

    @Before("verify()")
    public void doVerify(){
        ServletRequestAttributes requestAttributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);

        if(cookie == null){
            // 抛出异常  并将请求路径存进session
            log.warn("【登录检验】无法在cookie中查到token的值");
            String requestURI = request.getRequestURI() + "?" + request.getQueryString();
            request.getSession().setAttribute("targetUrl",requestURI);

            throw new AuthorizeException();
        }
        /*String requestURI = request.getRequestURI();
        String queryString = request.getQueryString();
        log.info("提示信息：aspect,请求路径：{}?{}",requestURI,queryString);*/
    }
}
