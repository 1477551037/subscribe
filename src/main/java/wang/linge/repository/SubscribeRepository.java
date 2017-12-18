package wang.linge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wang.linge.dataobject.Subscribe;

import java.util.List;

/**
 * Created by linge on 2017/11/16.
 */
public interface SubscribeRepository extends JpaRepository<Subscribe,String> {

    List<Subscribe> findByUserId(String userId);
    List<Subscribe> findByFensId(String fensId);
    Integer countByFensId(String fensId);
    Integer countByUserId(String userId);
    Subscribe findByUserIdAndFensId(String userId,String fensId);
}
