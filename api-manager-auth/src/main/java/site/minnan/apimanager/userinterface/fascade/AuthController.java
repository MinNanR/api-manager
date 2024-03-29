package site.minnan.apimanager.userinterface.fascade;

import cn.hutool.json.JSONUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.minnan.apimanager.application.service.AuthUserService;
import site.minnan.apimanager.domain.vo.LoginVO;
import site.minnan.apimanager.userinterface.dto.LoginDTO;
import site.minnan.apimanager.userinterface.response.ResponseEntity;

import javax.validation.Valid;

/***
 * 权限controller
 * @author Minnan on 2021/12/30
 */
@Api(tags = "权限")
@RestController
@RequestMapping("/apiManager/auth")
@Slf4j
public class AuthController {

    @Autowired
    private AuthUserService authUserService;

    @ApiOperation("登录")
    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginDTO dto){
        log.info("登录信息， {}", JSONUtil.toJsonStr(dto));
        LoginVO vo = authUserService.login(dto);
        return ResponseEntity.success(vo);
    }
}
