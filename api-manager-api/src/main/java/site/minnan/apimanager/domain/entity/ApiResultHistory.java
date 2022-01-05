package site.minnan.apimanager.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * api结果修改记录
 *
 * @author Minnan on 2022/01/05
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("api_result_history")
public class ApiResultHistory {

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 接口id
     */
    private Integer apiId;

    /**
     * 接口修改记录id
     */
    private Integer apiModifyHistoryId;

    /**
     * 参数内容（JSON）
     */
    private String resultContent;

}
