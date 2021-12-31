package site.minnan.apimanager.userinterface.fascade;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.minnan.apimanager.application.service.UserService;
import site.minnan.apimanager.userinterface.dto.AddUserDTO;
import site.minnan.apimanager.userinterface.response.ResponseEntity;

@Api(tags = "用户管理")
@RestController
@RequestMapping("/apiManager/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(("添加用户"))
    @PostMapping("addUser")
    public ResponseEntity<?> addUser(AddUserDTO dto){
        userService.addUser(dto);
        return ResponseEntity.success();
    }
}
