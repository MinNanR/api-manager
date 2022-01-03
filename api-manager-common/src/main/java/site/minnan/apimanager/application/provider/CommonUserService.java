package site.minnan.apimanager.application.provider;

import site.minnan.apimanager.domain.entity.Principal;
import site.minnan.apimanager.domain.aggregate.AuthUser;

/**
 * 用于记载用户信息的service
 * @author Minnan on 2021/01/02
 */
public interface CommonUserService {

    /**
     * 根据用户名加载用户信息
     *
     * @return
     */
    AuthUser loadUserByUserName(String username);

    Principal loadPrincipalByUserName(String username);
}
