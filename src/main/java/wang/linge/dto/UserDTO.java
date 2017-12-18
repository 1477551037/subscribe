package wang.linge.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.Date;

/**
 * Created by linge on 2017/11/19.
 */
@Data
public class UserDTO {
    private String id; //id

    private String nickName; //昵称 一开始默认随机数

    private String headImage; //头像
    @JsonIgnore
    private String openId;  //微信openId

    private String description;  //简介

    private String phone;  //手机号

    private String region;  //地区

    @JsonIgnore
    private Integer status;  //状态
    @JsonIgnore
    private Integer publisher;//是否为可发布者 默认0 不是发布者

    private Date createTime;  //创建时间

    private Date updateTime;  //更新时间

    private Page<InformationDTO> informations; //发布的信息集合
}
