package wang.linge.exception;

import lombok.Data;
import wang.linge.enums.ExceptionEnum;

/**
 * Created by linge on 2017/11/18.
 */
@Data
public class SubscribeException extends RuntimeException {

    private Integer code;

    public SubscribeException(Integer code,String message){
        super(message);
        this.code = code;
    }

    public SubscribeException(ExceptionEnum exceptionEnum){
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
    }
}
