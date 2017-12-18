package wang.linge.convert;

import org.springframework.beans.BeanUtils;
import wang.linge.dataobject.User;
import wang.linge.dto.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by linge on 2017/11/19.
 */
public class User2UserDTOConverter {

    /**
     * 将单个User装换为UserDTO
     * @param user
     * @return
     */
    public static UserDTO convert(User user){
        UserDTO userDTO=new UserDTO();
        BeanUtils.copyProperties(user,userDTO);
        return userDTO;
    }

    /**
     * 将User集合转换为UserDTO集合
     * @param userList
     * @return
     */
    public static List<UserDTO> convert(List<User> userList){
        return userList.stream().map(e -> convert(e)).collect(Collectors.toList());
    }

}

