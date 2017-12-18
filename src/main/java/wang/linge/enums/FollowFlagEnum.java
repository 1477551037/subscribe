package wang.linge.enums;

import lombok.Getter;

/**
 * Created by linge on 2017/11/22.
 */
@Getter
public enum FollowFlagEnum {
    OWN(0,""),
    CONCERN(1,"已关注"),
    NOT_CONCERN(2,"未关注");

    FollowFlagEnum(Integer code, String info) {
        this.code = code;
        this.info = info;
    }

    private Integer code;

    private String info;
}
