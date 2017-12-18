package wang.linge.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import wang.linge.dataobject.Information;

/**
 * Created by linge on 2017/12/10.
 */
public interface InformationRepository extends MongoRepository<Information,String>{

    Integer countById(String userId);
    Page<Information> findByUserId(String userId, Pageable pageable);

}
