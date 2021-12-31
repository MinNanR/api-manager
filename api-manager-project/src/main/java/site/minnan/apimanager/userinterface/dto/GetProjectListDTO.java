package site.minnan.apimanager.userinterface.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("获取项目列表")
@Data
public class GetProjectListDTO extends ListQueryDTO {

    @ApiModelProperty(value = "查询关键字", required = false, example = "关键字")
    private String keyword;
}
