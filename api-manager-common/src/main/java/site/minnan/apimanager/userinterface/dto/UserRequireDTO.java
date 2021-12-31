package site.minnan.apimanager.userinterface.dto;

import io.swagger.annotations.ApiModelProperty;
import site.minnan.apimanager.domain.entity.Principal;

/**
 * 需要使用用户信息的接口
 *
 * @author Minnan on 2021/12/31
 */
public interface UserRequireDTO {

    @ApiModelProperty(hidden = true)
    void setUser(Principal user);
}
