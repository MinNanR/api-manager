package site.minnan.apimanager.userinterface.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 更新
 *
 * @author Minnan on 2022/01/03
 */
@ApiModel("更新项目参数")
@Data
public class UpdateProjectDTO {

    @ApiModelProperty(value = "项目id",required = true, example = "1")
    @NotNull
    private Integer id;

    @ApiModelProperty(value = "项目名称",required = true, example = "测试项目2")
    @NotBlank(message = "项目名称")
    private String projectName;
}
