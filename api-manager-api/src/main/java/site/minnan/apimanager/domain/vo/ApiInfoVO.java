package site.minnan.apimanager.domain.vo;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.minnan.apimanager.domain.aggregate.Api;
import site.minnan.apimanager.domain.entity.ApiParam;
import site.minnan.apimanager.domain.entity.ApiResult;

import java.util.List;
import java.util.Map;

/**
 * 接口详细信息
 *
 * @author Minnan on 2022/01/05
 */
@Data
public class ApiInfoVO {

    @ApiModelProperty(value = "id", example = "1")
    private Integer id;

    @ApiModelProperty(value = "项目id", example = "8")
    private Integer projectId;

    @ApiModelProperty(value = "项目名称", example = "小超市进销存管理系统")
    private String projectName;

    @ApiModelProperty(value = "接口名称", example = "添加用户")
    private String apiName;

    @ApiModelProperty(value = "接口地址", example = "/project/user/addUser")
    private String url;

    @ApiModelProperty(value = "请求方法", example = "POST")
    private String method;

    @ApiModelProperty(value = "所需请求头", example = "\"Content-Type\": \"application/json\"")
    private Map<String, String> headers;

    @ApiModelProperty(value = "接口特殊说明",example = "说明")
    private String comment;

    @ApiModelProperty(value = "参数列表")
    private List<ApiParam> paramList;

    @ApiModelProperty(value = "返回值列表")
    private List<ApiResult> resultList;

    public ApiInfoVO(Api api){
        this.id = api.getId();
        this.projectId = api.getProjectId();
        this.projectName = api.getProjectName();
        this.apiName = api.getApiName();
        this.url = api.getUrl();
        this.method = api.getMethod();
        this.headers = api.getHeaders();
        this.comment = api.getComment();
        this.paramList = JSONUtil.toList(JSONUtil.parseArray(api.getParam()), ApiParam.class);
        this.resultList = JSONUtil.toList(JSONUtil.parseArray(api.getResult()), ApiResult.class);
    }
}
