package wang.linge.dto;

import lombok.Data;

/**
 * Created by linge on 2017/11/19.
 */
@Data
public class InformationDTO {

    private String id;  //id

    private String title;  //标题

    private String content;  //信息主体

    private String photo; //缩略图

    private String description; //描述  describes 改为description

    private String type;  //类型

    private String userId;  //作者openId 改为userId

    private String authorName; //作者昵称

    private String authorImage; //作者头像

    private Integer readingQuantity; //阅读量

    private Integer display;  //是否显示  0为显示 1为禁止显示

    private String createTime;  //创建时间

    private String updateTime;  //更新时间
}
