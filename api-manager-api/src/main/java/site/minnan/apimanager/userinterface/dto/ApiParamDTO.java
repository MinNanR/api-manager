package site.minnan.apimanager.userinterface.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/***
 * 添加接口的参数
 * @author Minnan on 2022/01/04
 */
@ApiModel("接口参数")
@Data
public class ApiParamDTO {

    @ApiModelProperty(value = "字段名称", required = true, example = "用户名")
    @NotBlank(message = "字段名称不能为空")
    private String paramName;

    @ApiModelProperty(value = "字段类型", required = true, example = "String")
    @NotBlank(message = "字段类型不能为空")
    private String type;

    @ApiModelProperty(value = "是否必传", allowableValues = "0(非必穿),1(必传)", example = "1")
    @NotNull(message = "是否必传不能为空")
    private Integer required;

    @ApiModelProperty(value = "是否为枚举类型参数", allowableValues = "0(否),1(是)", example = "0")
    private Integer whetherEnum;

    @ApiModelProperty(value = "枚举参数取值表")
    private Map<String, String> enumValue;

    @ApiModelProperty(value = "字段特殊说明")
    private String comment;

    @ApiModelProperty(value = "子参数")
    private List<ApiParamDTO> subParam;
}
