package site.minnan.apimanager.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.minnan.apimanager.domain.aggregate.Api;

/**
 * API列表查询返回值
 *
 * @author Minnan on 2022/01/05
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiListVO {

    @ApiModelProperty(value = "id", example = "1")
    private Integer id;

    @ApiModelProperty(value = "接口名称",example = "添加用户")
    private String apiName;

    @ApiModelProperty(value = "接口地址",example = "/project/user/addUser")
    private String url;

    public static ApiListVO of(Api api){
        return ApiListVO.builder()
                .id(api.getId())
                .apiName(api.getApiName())
                .url(api.getUrl())
                .build();
    }
}
