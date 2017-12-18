package wang.linge.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by linge on 2017/11/22.
 */
@Data
public class ResultVO<T> implements Serializable{


    private static final long serialVersionUID = -6559088642493831946L;

    private Integer code;

    private String message;

    private T Data;
}
