package wang.linge.service;

import org.springframework.data.domain.Pageable;
import wang.linge.dto.UserDTO;
import wang.linge.vo.UserVO;

/**
 * Created by linge on 2017/11/19.
 */
public interface UserService {
    /*
    //创建用户
    //UserDTO createUser(UserDTO userDTO);

    //修改用户信息
    //UserDTO updateUser(UserDTO userDTO);

    //删除用户
    //boolean deleteUser(String uid);

    //拉黑用户
    //UserDTO pullblack(String uid);
    */

    //查找用户
    UserDTO findOne(String uid);

    //通过openId查询用户
    UserDTO findOneByOpenId(String openId);

    //进入个人中心，获取用户信息以及发布的信息
    UserVO findUserCenter(String currentUserId,String userId);

    //进入修改页面，获取用户信息
    UserDTO joinUserEdit(String openId);


}