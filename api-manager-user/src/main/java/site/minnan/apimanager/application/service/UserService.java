package site.minnan.apimanager.application.service;

import site.minnan.apimanager.userinterface.dto.AddUserDTO;

/**
 *
 * @author Minnan on 2021/12/31
 */
public interface UserService {

    /**
     * 添加用户
     * @param dto
     */
    void addUser(AddUserDTO dto);
}
