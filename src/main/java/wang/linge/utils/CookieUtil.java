package wang.linge.utils;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by linge on 2017/11/21.
 */
public class CookieUtil {

    /**
     * 设置指定name和value的cookie 并设置超时时间
     * @param response
     * @param name
     * @param value
     * @param maxAge
     */
    public static void set(HttpServletResponse response,
                           String name,String value,int maxAge){
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
     * 返回cookie
     * @param request
     * @param name
     * @return
     */
    public static Cookie get(HttpServletRequest request, String name){
        Map<String, Cookie> cookieMap = readCookieMap(request);
        if(cookieMap.containsKey(name)){
            return cookieMap.get(name);
        }else{
            return null;
        }
    }

    /**
     * 返回指定name值cookie的value值
     * @param request
     * @param name
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String name){
        Map<String, Cookie> cookieMap = readCookieMap(request);
        if(cookieMap.containsKey(name)){
            return cookieMap.get(name).getValue();
        }else{
            return null;
        }
    }

    /**
     * 从request中读取cookie并封装到map
     * @param request
     * @return
     */
    public static Map<String,Cookie> readCookieMap(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        HashMap<String,Cookie> map = new HashMap<>();
        if(cookies !=null){
            for(Cookie cookie:cookies){
                map.put(cookie.getName(),cookie);
            }
        }
        return map;
    }
}
