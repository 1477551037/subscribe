package wang.linge.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wang.linge.convert.UserDTO2SubscribeVO;
import wang.linge.dataobject.Subscribe;
import wang.linge.dto.MutualSubscribeDTO;
import wang.linge.dto.UserDTO;
import wang.linge.enums.ExceptionEnum;
import wang.linge.enums.FollowFlagEnum;
import wang.linge.exception.SubscribeException;
import wang.linge.repository.SubscribeRepository;
import wang.linge.service.SubscribeService;
import wang.linge.service.UserService;
import wang.linge.utils.KeyUtil;
import wang.linge.vo.SubscribeListVo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by linge on 2017/11/18.
 */
@Service
@Transactional
public class SubscribeServiceImpl implements SubscribeService{

    @Autowired
    private SubscribeRepository subscribeRepository;

    @Autowired
    private UserService userService;

    @Override
    public void follow(String userId, String fensId) {
        Subscribe subscribe = new Subscribe();
        subscribe.setId(KeyUtil.genUniqueKey());
        Integer checkFollow = checkFollow(userId, fensId);
        if(checkFollow != FollowFlagEnum.NOT_CONCERN.getCode()){
            throw new SubscribeException(ExceptionEnum.ALREADY_FOLLOW);
        }
        subscribe.setUserId(userId);
        subscribe.setFensId(fensId);
        subscribeRepository.save(subscribe);
    }

    @Override
    public void cancel(String userId, String fensId) {

        UserDTO userDTO = userService.findOne(fensId);
        if(userDTO == null){
            throw new SubscribeException(ExceptionEnum.USER_NOT_EXISTENT);
        }
        Subscribe result = subscribeRepository.findByUserIdAndFensId(userId, fensId);
        if(result == null){
            throw new SubscribeException(ExceptionEnum.NOT_CONCERN);
        }else{
            subscribeRepository.delete(result);
        }

    }

    @Override
    public List<SubscribeListVo> findFens(String userId) {
        //return subscribeRepository.findByUserId(userId);
        List<Subscribe> subscribeList = subscribeRepository.findByFensId(userId);
        List<SubscribeListVo> subscribeListVos = subscribeList.stream()
                .map(e -> UserDTO2SubscribeVO.convert(userService.findOne(e.getUserId())))
                .collect(Collectors.toList());
        return subscribeListVos;
    }

    @Override
    public Integer countFensTotal(String fensId) {
        return subscribeRepository.countByFensId(fensId);
    }

    @Override
    public List<SubscribeListVo> findFollow(String fensId) {
        List<Subscribe> subscribeList = subscribeRepository.findByUserId(fensId);
        List<SubscribeListVo> subscribeListVos = subscribeList.stream()
                .map(e -> UserDTO2SubscribeVO.convert(userService.findOne(e.getFensId())))
                .collect(Collectors.toList());
        return subscribeListVos;
    }

    @Override
    public Integer countUserTotal(String userId) {
        return subscribeRepository.countByUserId(userId);
    }

    @Override
    public Integer checkFollow(String userId, String fensId) {
        if(userId.equals(fensId)){
            return FollowFlagEnum.OWN.getCode();
        }
        Subscribe result = subscribeRepository.findByUserIdAndFensId(userId, fensId);
        if(result != null){
            return FollowFlagEnum.CONCERN.getCode();
        }
        return FollowFlagEnum.NOT_CONCERN.getCode();
    }

    @Override
    public List<SubscribeListVo> findMutualSubscribe(String userId) {
        List<Subscribe> subscribeList = subscribeRepository.findByUserId(userId);
        List<SubscribeListVo> voList = new ArrayList();
        for(Subscribe subscribe:subscribeList){
            if(checkFollow(subscribe.getFensId(),subscribe.getUserId())==FollowFlagEnum.CONCERN.getCode()){
                voList.add(UserDTO2SubscribeVO.convert(userService.findOne(subscribe.getFensId())));
            }
        }
        return voList;
    }

    @Override
    public Integer checkMutualFollow(String userId, String fensId) {
        Integer isFollow = checkFollow(userId, fensId);
        Integer isFens = checkFollow(fensId, userId);
        if(isFollow == FollowFlagEnum.CONCERN.getCode() && isFens == isFollow ){
            return FollowFlagEnum.CONCERN.getCode();
        }
        return FollowFlagEnum.NOT_CONCERN.getCode();
    }
}
