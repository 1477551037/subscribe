package wang.linge.service;

import wang.linge.vo.UserVO;

/**
 * Created by linge on 2017/12/10.
 */
public interface InformationService {

    /**
     * 设置用户主页展示的文章相关数据
     * @param userVO
     * @return
     */
    UserVO decorateUser(UserVO userVO);
}
