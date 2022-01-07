package site.minnan.apimanager.domain.vo;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import site.minnan.apimanager.domain.entity.ApiParam;
import site.minnan.apimanager.domain.entity.ApiResult;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 接口修改记录
 *
 * @author Minna on 2022/01/05
 */
@ApiModel("接口修改记录")
@Data
public class ApiModifyHistoryVO {

    @ApiModelProperty(value = "id", example = "1")
    private Integer id;

    @ApiModelProperty(value = "接口id",example = "1")
    private Integer apiId;

    @ApiModelProperty(value = "接口名称", example = "添加用户")
    private String apiName;

    @ApiModelProperty(value = "接口地址", example = "/project/user/addUser")
    private String url;

    @ApiModelProperty(value = "请求方法", example = "POST")
    private String method;

    @ApiModelProperty(value = "所需请求头", example = "{\"Content-Type\":\"application/json\"}")
    private Map<String, String> headers;

    @ApiModelProperty(value = "接口特殊说明", example = "说明")
    private String comment;

    @ApiModelProperty(value = "参数列表")
    private List<ApiParam> paramList;

    @ApiModelProperty(value = "结果列表")
    private List<ApiResult> resultList;

    @ApiModelProperty(value = "修改人名称", example = "张三")
    private String createUserName;

    @ApiModelProperty(value = "修改时间（格式：yyyy-MM-dd HH:mm", example = "2021-01-04 09:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Timestamp createTime;

    public void setParamList(String paramString) {
        this.paramList = JSONUtil.toList(JSONUtil.parseArray(paramString), ApiParam.class);
    }

    public void setResultList(String resultString) {
        this.resultList = JSONUtil.toList(JSONUtil.parseArray(resultString), ApiResult.class);
    }

    public void setHeaders(String headers){
        this.headers = JSONUtil.toBean(headers, HashMap.class);
    }
}
