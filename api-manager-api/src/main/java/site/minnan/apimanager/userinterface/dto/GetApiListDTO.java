package site.minnan.apimanager.userinterface.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 根据项目获取API列表参数
 *
 * @author Minnan on 2022/01/05
 */
@ApiModel("根据项目获取API列表参数")
@Data
public class GetApiListDTO {

    @ApiModelProperty(value = "项目id", required = true, example = "1")
    @NotNull(message = "未指定项目")
    private Integer projectId;
}
