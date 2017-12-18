package wang.linge.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import wang.linge.convert.User2UserDTOConverter;
import wang.linge.convert.UserDTO2UserConverter;
import wang.linge.dataobject.User;
import wang.linge.dto.UserDTO;
import wang.linge.repository.InformationRepository;
import wang.linge.repository.UserRepository;
import wang.linge.service.SubscribeService;
import wang.linge.service.UserService;
import wang.linge.vo.UserVO;

/**
 * 原由家鑫编写  删除部分不必要代码后修改
 * Created by linge on 2017/11/19.
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubscribeService subscribeService;

    @Autowired
    private InformationRepository informationRepository;

    /**
     * 查找用户
     *
     * @param uid
     * @return
     */
    public UserDTO findOne(String uid) {
        User user = userRepository.findOne(uid);
        if (user != null) {
            UserDTO convert = User2UserDTOConverter.convert(user);
            return convert;
        }
        return null;
    }


    public UserDTO findOneByOpenId(String openId) {
        if (StringUtils.isEmpty(openId)) {
            log.info("【微信授权】openId不能为空! openId={}", openId);
            //TODO throw new UserException(UserEnum.USER_OPENID_ISEMPTY);
        }
        User user = userRepository.findByOpenId(openId);
        if (user == null) {
            log.info("【微信授权登录】首次登录! openId={}", openId);
            return null;
        }
        UserDTO convert = User2UserDTOConverter.convert(user);
        return convert;
    }

    /**
     * 进入个人中心，获取个人信息及发布的文章
     *
     * @param
     * @return
     */
    @Override
    public UserVO findUserCenter(String currentUserId,String userId) {
        UserDTO userDTO = findOne(userId);
        UserVO userVO = new UserVO();
        if (userDTO == null) {
            log.info("【个人中心】用户不存在! openId={}", userId);
            //TODO throw new UserException(UserEnum.USER_NO_EXIST);
        }
        BeanUtils.copyProperties(userDTO,userVO);
        userVO.setUserTotal(subscribeService.countUserTotal(userId));
        userVO.setFensTotal(subscribeService.countFensTotal(userId));
        userVO.setFollowFlag(subscribeService.checkFollow(currentUserId, userId));
        userVO.setArticleTotal(informationRepository.countById(userId));

        return userVO;
    }

    /**
     * 进入修改页面，获取用户信息
     *
     * @param openId
     * @return
     */
    public UserDTO joinUserEdit(String openId) {

        UserDTO userDTO = findOneByOpenId(openId);
        if (userDTO == null) {
            log.info("【个人中心】用户不存在! openId={}", openId);
            //TODO throw new UserException(UserEnum.USER_NO_EXIST);
        }

        return userDTO;
    }

    /**
     * 更新用户信息
     *
     * @param userDTO
     * @return
     */
    public UserDTO updateUserInfo(UserDTO userDTO) {
        User convert = UserDTO2UserConverter.convert(userDTO);
        User save = userRepository.save(convert);
        UserDTO userDTO1 = User2UserDTOConverter.convert(save);
        return userDTO1;
    }
}
