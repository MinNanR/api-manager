package site.minnan.apimanager.application.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.Digester;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import site.minnan.apimanager.application.service.AuthUserService;
import site.minnan.apimanager.domain.aggregate.AuthUser;
import site.minnan.apimanager.domain.entity.Principal;
import site.minnan.apimanager.domain.mapper.AuthUserMapper;
import site.minnan.apimanager.domain.vo.LoginVO;
import site.minnan.apimanager.infrastructure.exception.LoginException;
import site.minnan.apimanager.infrastructure.utils.JwtUtil;
import site.minnan.apimanager.userinterface.dto.LoginDTO;

import javax.servlet.ServletContext;

/**
 * @author Minnan on 2021/12/31
 */
@Service
public class AuthUserServiceImpl implements AuthUserService {

    @Autowired
    private AuthUserMapper authUserMapper;

    @Autowired
    private Digester passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 登录校验
     *
     * @param dto
     * @return
     */
    @Override
    public LoginVO login(LoginDTO dto) {
        QueryWrapper<AuthUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", dto.getUsername());
        AuthUser authUser = loadUserByUserName(dto.getUsername());
        if (authUser == null) {
            throw new LoginException("用户不存在");
        }
        String encodedPassword = passwordEncoder.digestHex(dto.getPassword());
        if (!StrUtil.equals(encodedPassword, authUser.getPassword())) {
            throw new LoginException("密码错误");
        }
        Principal principal = authUser.principal();
        String token = jwtUtil.generateToken(principal);
        ThreadLocal<String> objectThreadLocal = ThreadLocal.withInitial(() -> "");
        return new LoginVO(token);
    }


    @Cacheable(cacheNames = "user", key = "#username")
    public AuthUser loadUserByUserName(String username) {
        QueryWrapper<AuthUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return authUserMapper.selectOne(queryWrapper);
    }
}
