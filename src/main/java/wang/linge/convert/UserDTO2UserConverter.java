package wang.linge.convert;

import org.springframework.beans.BeanUtils;
import wang.linge.dataobject.User;
import wang.linge.dto.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by linge on 2017/11/19.
 */
public class UserDTO2UserConverter {
    /**
     * 将单个UserDTO装换为User
     * @param userDTO
     * @return
     */
    public static User convert(UserDTO userDTO){
        User user=new User();
        BeanUtils.copyProperties(userDTO,user);
        return user;
    }

    /**
     * 将User集合转换为UserDTO集合
     * @param userList
     * @return
     */
    public static List<User> convert(List<UserDTO> userList){
        return userList.stream().map(e -> convert(e)).collect(Collectors.toList());
    }
}

