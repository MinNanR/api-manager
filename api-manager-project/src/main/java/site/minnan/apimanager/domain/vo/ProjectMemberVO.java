package site.minnan.apimanager.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 项目成员数据
 *
 * @author Minnan on 2022/01/04
 */
@ApiModel("项目成员数据")
@Data
public class ProjectMemberVO {

    @ApiModelProperty(value = "成员用户id", example = "1")
    private Integer userId;

    @ApiModelProperty(value = "成员名称", example = "张三")
    private String userName;

    @ApiModelProperty(value = "加入时间(格式：yyyy-MM-dd HH:mm)", example = "2022-01-04 09:00")
    private String participateTime;
}
