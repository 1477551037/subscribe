package wang.linge.utils;

import java.util.Random;

/**
 * Created by linge on 2017/11/18.
 */
public class KeyUtil {

    /**
     * 生成唯一的关键字
     * @return
     */
    public synchronized static String genUniqueKey(){

        Random random = new Random();
        Integer number= random.nextInt(900000)+100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
