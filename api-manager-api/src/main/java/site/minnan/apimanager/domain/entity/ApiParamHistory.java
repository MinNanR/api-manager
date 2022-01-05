package site.minnan.apimanager.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * api参数修改记录
 *
 * @author Minnan on 2022/01/05
 */
@TableName("api_param_history")
@Data
public class ApiParamHistory {

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
    private String paramContent;
}
