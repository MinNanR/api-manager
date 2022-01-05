package site.minnan.apimanager.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import site.minnan.apimanager.userinterface.dto.ApiResultDTO;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

/**
 * api结果
 *
 * @author Minnan on 2022/01/05
 */
@ApiModel("api参数")
@Data
public class ApiResult {

    @ApiModelProperty(value = "字段名称", example = "用户名")
    @NotBlank(message = "字段名称不能为空")
    private String resultName;

    @ApiModelProperty(value = "字段类型", example = "String")
    @NotBlank(message = "字段类型不能为空")
    private String type;

    @ApiModelProperty(value = "是否为枚举类型参数", allowableValues = "0(非必穿),1(必传)", example = "0")
    private Integer whetherEnum;

    @ApiModelProperty(value = "枚举参数取值表")
    private Map<String, String> enumValue;

    @ApiModelProperty(value = "字段特殊说明")
    private String comment;

    @ApiModelProperty(value = "子参数")
    private List<ApiResultDTO> subResult;

}
