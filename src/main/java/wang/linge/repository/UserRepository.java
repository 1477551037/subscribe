package wang.linge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wang.linge.dataobject.User;

/**
 * Created by linge on 2017/11/16.
 */
public interface UserRepository extends JpaRepository<User,String>{
    User findByOpenId(String openId);
}
