package site.minnan.apimanager.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * api参数
 *
 * @author Minnan on 2022/01/05
 */
@ApiModel("api参数")
@Data
public class ApiParam {

    @ApiModelProperty(value = "字段名称", example = "username")
    private String paramName;

    @ApiModelProperty(value = "字段说明", example = "用户名")
    private String description;

    @ApiModelProperty(value = "字段类型",  example = "String")
    private String type;

    @ApiModelProperty(value = "是否必传", allowableValues = "0(非必穿),1(必传)", example = "1")
    private Integer required;

    @ApiModelProperty(value = "是否为枚举类型参数", allowableValues = "0(非必穿),1(必传)", example = "0")
    private Integer whetherEnum;

    @ApiModelProperty(value = "枚举参数取值表")
    private Map<String, String> enumValue;

    @ApiModelProperty(value = "字段特殊说明")
    private String comment;

    @ApiModelProperty(value = "子参数")
    private List<ApiParam> subParam;
}
