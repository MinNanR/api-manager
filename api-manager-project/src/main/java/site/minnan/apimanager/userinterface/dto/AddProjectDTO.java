package site.minnan.apimanager.userinterface.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 添加项目参数
 *
 * @author Minnan on 2022/01/03
 */
@ApiModel("添加项目参数")
@Data
public class AddProjectDTO {

    @ApiModelProperty(value = "项目名称", required = true, example = "项目名称")
    @NotBlank(message = "项目名称不能为空")
    private String projectName;
}
