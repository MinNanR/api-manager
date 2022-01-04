package site.minnan.apimanager.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * 项目与用户关联关系
 *
 * @author Minnan on 2022/01/04
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectUserRelevance {

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 项目id
     */
    private Integer projectId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 创建时间（加入时间）
     */
    private Timestamp createTime;
}
