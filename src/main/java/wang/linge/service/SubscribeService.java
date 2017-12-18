package wang.linge.service;

import org.springframework.data.domain.Pageable;
import wang.linge.dataobject.Subscribe;
import wang.linge.dto.MutualSubscribeDTO;
import wang.linge.vo.SubscribeListVo;

import java.util.List;

/**
 * Created by linge on 2017/11/18.
 */
public interface SubscribeService {

    /**
     * 新增关注的记录
     * @param userId
     * @param fensId
     */
    void follow(String userId,String fensId);

    /**
     * 取消关注
     * @param userId
     * @param fensId
     */
    void cancel(String userId,String fensId);

    /**
     * 返回所有的粉丝
     * @param userId
     * @return
     */
    List<SubscribeListVo> findFens(String userId);

    /**
     * 查询粉丝的数量
     * @param userId
     * @return
     */
    Integer countFensTotal(String userId);

    /**
     * 返回所有已关注的用户
     * @param fensId
     * @return
     */
    List<SubscribeListVo> findFollow(String fensId);

    /**
     * 查询已关注的数量
     * @param userId
     * @return
     */
    Integer countUserTotal(String userId);

    /**
     * 是否已关注
     * @param userId
     * @param fensId
     * @return FollowFlagEnum.code
     */
    Integer checkFollow(String userId,String fensId);

    List<SubscribeListVo> findMutualSubscribe(String userId);

    Integer checkMutualFollow(String userId,String fensId);
}
