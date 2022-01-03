package site.minnan.apimanager.domain.aggregate;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import site.minnan.apimanager.domain.entity.Principal;

import java.sql.Timestamp;
import java.time.Instant;

/**
 * 项目对象
 *
 * @author Minnan on 2022/01/03
 */
@TableName("project")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 创建人id
     */
    private Integer createUserId;

    /**
     * 创建人姓名
     */
    private String createUserName;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 更新人id
     */
    private Integer updateUserId;

    /**
     * 更新人姓名
     */
    private String updateUserName;

    /**
     * 更新时间
     */
    private Timestamp updateTime;

    public void setCreateUser(Principal principal) {
        Timestamp now = Timestamp.from(Instant.now());
        this.createTime = now;
        this.updateTime = now;
        if (principal != null) {
            this.createUserId = principal.getUserId();
            this.createUserName = principal.getRealName();
            this.updateUserId = principal.getUserId();
            this.updateUserName = principal.getRealName();
        }
    }

    public void setUpdateUser(Principal principal) {
        this.updateTime = Timestamp.from(Instant.now());
        if (principal != null) {
            this.updateUserId = principal.getUserId();
            this.updateUserName = principal.getRealName();
        }
    }
}
