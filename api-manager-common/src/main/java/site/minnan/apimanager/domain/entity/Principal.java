package site.minnan.apimanager.domain.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 * 当前操作用户
 * @author Minnan on 2021/12/31
 */
@Data
public class Principal {

    /**
     * 用户id
     */
    @ApiModelProperty(hidden = true)
    private Integer userId;

    /**
     * 用户名
     */
    @ApiModelProperty(hidden = true)
    private String username;

    /**
     * 用户真实姓名
     */
    @ApiModelProperty(hidden = true)
    private String realName;

    /**
     * 用户密码戳
     */
    @ApiModelProperty(hidden = true)
    private String passwordStamp;
}
