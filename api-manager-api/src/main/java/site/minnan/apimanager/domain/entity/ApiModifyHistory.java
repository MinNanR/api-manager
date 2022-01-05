package site.minnan.apimanager.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Map;

/**
 * 接口修改记录
 *
 * @author Minnan on 2022/01/05
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiModifyHistory{

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
     * 接口名称
     */
    private String apiName;

    /**
     * 接口地址
     */
    private String url;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 所需请求头
     */
    private Map<String, String> headers;

    /**
     * 接口特殊说明
     */
    private String comment;

    /**
     * 记录修改人id
     */
    private Integer createUserId;

    /**
     * 记录修改人名称
     */
    private String createUserName;

    /**
     * 记录修改时间
     */
    private Timestamp createTime;

    /**
     * 设置创建者
     *
     * @param principal 创建者
     */
    public void setCreateUser(Principal principal) {
        if(principal != null){
            this.createUserId = principal.getUserId();
            this.createUserName = principal.getRealName();
        }
        this.createTime = Timestamp.from(Instant.now());
    }

}
