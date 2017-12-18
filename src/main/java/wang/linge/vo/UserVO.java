package wang.linge.vo;

import lombok.Data;
import wang.linge.dataobject.Information;

import java.util.List;

/**
 * Created by linge on 2017/12/10.
 */
@Data
public class UserVO {

    private String id; //id

    private String nickName; //昵称 一开始默认随机数

    private String headImage; //头像

    private String description;  //简介

    private String phone;  //手机号

    private String region;  //地区

    private Integer userTotal;    //关注数量

    private Integer fensTotal;   //粉丝数量

    private Integer articleTotal;   //发表的文章数量

    private Integer followFlag;   //和当前用户是否已关注

    private List<Information> article;  //展示的文章
}
