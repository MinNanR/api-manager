package site.minnan.apimanager.userinterface.fascade;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.json.JSONUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.minnan.apimanager.domain.entity.Principal;
import site.minnan.apimanager.infrastructure.context.UserHolder;
import site.minnan.apimanager.userinterface.dto.GetProjectListDTO;
import site.minnan.apimanager.userinterface.response.ResponseEntity;

@Api(tags = "项目")
@RequestMapping("/apiManager/project")
@RestController
@Slf4j
public class ProjectController {

    @ApiOperation("查看项目列表")
    @PostMapping("getProjectList")
    public ResponseEntity<?> getProjectList(@RequestBody GetProjectListDTO dto) {
        Principal principal = UserHolder.getPrincipal();
        log.info("{}", JSONUtil.toJsonStr(principal));
        return ResponseEntity.success(ListUtil.empty());
    }

}
