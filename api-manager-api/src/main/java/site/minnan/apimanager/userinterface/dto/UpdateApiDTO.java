package site.minnan.apimanager.userinterface.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import site.minnan.apimanager.domain.entity.ApiParam;
import site.minnan.apimanager.domain.entity.ApiResult;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * 更新接口参数
 *
 * @author Minnan on 2022/01/05
 */
@Data
@ApiModel("更新接口参数")
public class UpdateApiDTO {

    @ApiModelProperty(value = "接口id",required = true, example = "1")
    private Integer id;

    @ApiModelProperty(value = "接口名称", required = true, example = "添加用户")
    @NotBlank(message = "接口名称不能为空")
    private String apiName;

    @ApiModelProperty(value = "接口地址", required = true, example = "/project/addUser")
    @NotBlank(message = "接口地址不能为空")
    private String url;

    @ApiModelProperty(value = "请求方法", required = false, example = "POST")
    @NotBlank(message = "请求方法不能为空")
    private String method;

    @ApiModelProperty(value = "接口特殊说明", required = false, example = "注意事项")
    private String comment;

    @ApiModelProperty(value = "请求头要求", required = false, example = "{\"Content-Type\":\"application/json\"}")
    private Map<String, String> headers;

    @ApiModelProperty(value = "api参数信息")
    private List<ApiParam> paramList;

    @ApiModelProperty(value = "api返回数据信息")
    private List<ApiResult> resultList;
}
