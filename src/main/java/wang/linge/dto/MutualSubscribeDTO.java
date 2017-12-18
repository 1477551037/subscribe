package wang.linge.dto;

import lombok.Data;
import wang.linge.vo.SubscribeListVo;

import java.util.List;

/**
 * Created by linge on 2017/11/26.
 */
@Data
public class MutualSubscribeDTO {


    private Integer totalElements;


    private List<SubscribeListVo> data;
}
