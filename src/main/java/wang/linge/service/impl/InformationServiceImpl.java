package wang.linge.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wang.linge.dataobject.Information;
import wang.linge.repository.InformationRepository;
import wang.linge.service.InformationService;
import wang.linge.vo.UserVO;

/**
 * Created by linge on 2017/12/10.
 */
@Service
@Transactional
public class InformationServiceImpl implements InformationService{

    @Autowired
    private InformationRepository repository;

    @Override
    public UserVO decorateUser(UserVO userVO) {
        //设置文章数量
        userVO.setArticleTotal(repository.countById(userVO.getId()));
        //设置展示的文章
        Page<Information> informationPage = repository.findByUserId(userVO.getId(), new PageRequest(0, 5));
        userVO.setArticle(informationPage.getContent());
        return userVO;
    }
}
