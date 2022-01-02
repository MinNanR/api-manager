package site.minnan.apimanager.application.service.impl;

import cn.hutool.crypto.digest.Digester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.minnan.apimanager.application.service.UserService;
import site.minnan.apimanager.domain.entity.aggregate.AuthUser;
import site.minnan.apimanager.domain.entity.mapper.AuthUserMapper;
import site.minnan.apimanager.userinterface.dto.AddUserDTO;

import java.util.UUID;

/**
 *
 * @author Minnan on 2021/12/31
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private Digester passwordEncoder;

    @Autowired
    private AuthUserMapper authUserMapper;

    /**
     * 添加用户
     *
     * @param dto
     */
    @Override
    public void addUser(AddUserDTO dto) {
        String encodedPassword = passwordEncoder.digestHex(dto.getPassword());
        String passwordStamp = UUID.randomUUID().toString().replaceAll("-", "");
        AuthUser user = AuthUser.builder()
                .username(dto.getUsername())
                .password(encodedPassword)
                .realName(dto.getRealName())
                .passwordStamp(passwordStamp)
                .build();
        user.createUser(dto.getUser());
        authUserMapper.insert(user);
    }
}
