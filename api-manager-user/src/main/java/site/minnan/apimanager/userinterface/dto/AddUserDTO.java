package site.minnan.apimanager.userinterface.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 添加用户参宿和
 * @author Minnan on 2021/12/31
 */
@ApiModel("添加用户参数")
@Data
public class AddUserDTO{

    @ApiModelProperty(value = "用户名", required = true, example = "admin")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "密码，MD5加密，32位小写",required = true, example = "e10adc3949ba59abbe56e057f20f883e")
    @NotBlank(message = "密码不能为空")
    private String password;

    @ApiModelProperty(value = "真实姓名", required = true, example = "张三")
    @NotBlank(message = "真实姓名不能为空")
    private String realName;
}
