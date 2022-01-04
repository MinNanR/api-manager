package site.minnan.apimanager.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 项目详情数据
 *
 * @author Minnan on 2022/01/04
 */
@ApiModel("项目详情数据")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectInfoVO {

    @ApiModelProperty(value = "id", example = "1")
    private Integer id;

    @ApiModelProperty(value = "项目名称", example = "测试名称")
    private String projectName;

    @ApiModelProperty(value = "创建人名称",example = "张三")
    private String createUserName;

    @ApiModelProperty(value = "创建时间（格式：yyyy-MM-dd HH:mm）",example = "2022-01-04 09:00")
    private String createTime;

    @ApiModelProperty(value = "项目成员")
    private List<ProjectMemberVO> projectMemberList;

}
