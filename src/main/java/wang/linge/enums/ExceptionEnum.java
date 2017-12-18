package wang.linge.enums;

import lombok.Getter;

/**
 * Created by linge on 2017/11/18.
 */
@Getter
public enum ExceptionEnum {

    NOT_CONCERN(1,"尚未关注该用户"),
    USER_NOT_EXISTENT(2,"用户不存在"),
    AUTHORIZE_FAIL(3,"网页授权出现异常"),
    ALREADY_FOLLOW(4,"你已关注该用户");

    private Integer code;

    private String message;

    ExceptionEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
