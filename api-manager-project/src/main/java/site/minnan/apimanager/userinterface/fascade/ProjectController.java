package site.minnan.apimanager.userinterface.fascade;

import cn.hutool.core.collection.ListUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.minnan.apimanager.userinterface.dto.GetProjectListDTO;
import site.minnan.apimanager.userinterface.response.ResponseEntity;

import java.util.ArrayList;

@Api(tags = "项目")
@RequestMapping("/apiManager/project")
@RestController
public class ProjectController {

    @ApiOperation("查看项目列表")
    @PostMapping("getProjectList")
    public ResponseEntity<?> getProjectList(GetProjectListDTO dto){
        return ResponseEntity.success(ListUtil.empty());
    }

}
