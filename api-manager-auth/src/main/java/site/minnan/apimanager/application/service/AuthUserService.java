package site.minnan.apimanager.application.service;


import site.minnan.apimanager.domain.vo.LoginVO;
import site.minnan.apimanager.userinterface.dto.LoginDTO;

public interface AuthUserService {

    /**
     * 登录校验
     *
     * @param dto 登录参数
     */
    LoginVO login(LoginDTO dto);
}
