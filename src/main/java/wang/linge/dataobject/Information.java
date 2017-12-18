package wang.linge.dataobject;

import lombok.Data;

/**
 * Created by linge on 2017/12/10.
 */
@Data
public class Information {

    private String id;  //id

    private String title;  //标题

    private String content;  //信息主体

    private String photo; //缩略图

    private String description; //描述  describes 改为description

    private String type;  //类型

    private String userId;  //作者openId 改为userId

    private Integer readingQuantity; //阅读量

    private Integer display;  //是否显示  0为显示 1为禁止显示

    private String createTime;  //创建时间

    private String updateTime;  //更新时间
}

