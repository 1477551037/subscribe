package wang.linge.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by linge on 2017/11/16.
 */
@Entity
@Data
@DynamicInsert
public class Subscribe {

    @Id
    private String id;

    private String userId;

    private String fensId;

    private Date createTime;
}
