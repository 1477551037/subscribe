package wang.linge.convert;

import org.springframework.beans.BeanUtils;
import wang.linge.dto.UserDTO;
import wang.linge.vo.SubscribeListVo;

/**
 * Created by linge on 2017/11/20.
 */
public class UserDTO2SubscribeVO {

    public static SubscribeListVo convert(UserDTO userDTO){
        if(userDTO == null){
            return new SubscribeListVo();
        }
        SubscribeListVo subscribeListVo = new SubscribeListVo();
        BeanUtils.copyProperties(userDTO,subscribeListVo);
        subscribeListVo.setUserId(userDTO.getId());
        return subscribeListVo;
    }
}
