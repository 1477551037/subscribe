package wang.linge.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by linge on 2017/11/21.
 */
@Data
@ConfigurationProperties(prefix = "authorizeUrl")
@Component
public class WechatAuthorizeUrlConfig {

    //域名
    private String domainName;

    //请求路径
    private String path;

    private String subscribe;

}
