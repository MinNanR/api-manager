import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.Digester;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import site.minnan.apimanager.UserApplication;
import site.minnan.apimanager.application.service.UserService;
import site.minnan.apimanager.userinterface.dto.AddUserDTO;

@SpringBootTest(classes = UserApplication.class)
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void addUserTest(){
        String password = DigestUtil.md5Hex("minnan35");
        AddUserDTO dto = new AddUserDTO();
        dto.setUsername("min");
        dto.setPassword(password);
        dto.setRealName("民难");
        userService.addUser(dto);
    }


}
