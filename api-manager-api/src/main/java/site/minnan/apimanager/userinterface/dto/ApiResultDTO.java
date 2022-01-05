package site.minnan.apimanager.userinterface.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/***
 * 添加接口的返回值
 * @author Minnan on 2022/01/04
 */
@ApiModel("添加接口的返回值")
@Data
public class ApiResultDTO {

    @ApiModelProperty(value = "字段名称", required = true, example = "username")
    @NotBlank(message = "字段名称不能为空")
    private String resultName;

    @ApiModelProperty(value = "字段说明" ,required = true, example = "")
    private String description;

    @ApiModelProperty(value = "字段类型", required = true, example = "String")
    @NotBlank(message = "字段类型不能为空")
    private String type;

    @ApiModelProperty(value = "是否为枚举类型参数", allowableValues = "0(否),1(是)", example = "0")
    private Integer whetherEnum;

    @ApiModelProperty(value = "枚举参数取值表")
    private Map<String, String> enumValue;

    @ApiModelProperty(value = "字段特殊说明")
    private String comment;

    @ApiModelProperty(value = "子参数")
    private List<ApiResultDTO> subResult;

}
