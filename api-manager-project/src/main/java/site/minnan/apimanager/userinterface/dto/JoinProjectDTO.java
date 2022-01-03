package site.minnan.apimanager.userinterface.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 加入项目参数
 *
 * @author Minnan on 2022/01/03
 */
@ApiModel("加入项目参数")
@Data
public class JoinProjectDTO {

    @ApiModelProperty(value = "项目id",required = true,example = "1")
    @NotNull
    private Integer id;
}
