package wang.linge.utils;

import wang.linge.vo.ResultVO;

/**
 * Created by linge on 2017/11/22.
 */
public class ResultVOUtil {

    public static ResultVO success(String message){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMessage(message);
        return resultVO;
    }

    public static ResultVO error(Integer code,String message){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMessage(message);
        return resultVO;
    }
}
