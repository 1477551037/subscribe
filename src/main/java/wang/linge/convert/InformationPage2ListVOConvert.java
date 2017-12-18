package wang.linge.convert;

import org.springframework.data.domain.Page;
import wang.linge.dataobject.Information;

import java.util.List;

/**
 * Created by linge on 2017/12/10.
 */
public class InformationPage2ListVOConvert {

    public static List<Information> convert(Page<Information> informationPage){
        List<Information> list = informationPage.getContent();
        return list;
    }
}
