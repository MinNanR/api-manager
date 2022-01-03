package site.minnan.apimanager.domain.vo;

import cn.hutool.core.date.DateUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.minnan.apimanager.domain.aggregate.Project;

/**
 * 项目列表查询参数
 *
 * @author Minnan on 2022/01/03
 */
@ApiModel("项目列表查询数据")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectListVO {

    @ApiModelProperty(value = "id", example = "1")
    private Integer id;

    @ApiModelProperty(value = "项目名称",example = "测试项目")
    private String projectName;


    @ApiModelProperty(value = "最后更新人", example = "张三")
    private String updateUserName;

    @ApiModelProperty(value = "最后更新时间，格式（yyyy-MM-dd HH:mm:ss)", example = "2022-01-04 10:00")
    private String updateTime;

    public static ProjectListVO vo(Project project){
        return ProjectListVO.builder()
                .id(project.getId())
                .projectName(project.getProjectName())
                .updateUserName(project.getUpdateUserName())
                .updateTime(DateUtil.format(project.getUpdateTime(), "yyyy-MM-dd HH:mm:ss"))
                .build();
    }
}
