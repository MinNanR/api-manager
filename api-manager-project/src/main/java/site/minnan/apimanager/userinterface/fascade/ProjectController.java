package site.minnan.apimanager.userinterface.fascade;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.minnan.apimanager.application.service.ProjectService;
import site.minnan.apimanager.domain.vo.ListQueryVO;
import site.minnan.apimanager.domain.vo.ProjectInfoVO;
import site.minnan.apimanager.domain.vo.ProjectListVO;
import site.minnan.apimanager.infrastructure.annotation.PreAuthorized;
import site.minnan.apimanager.userinterface.dto.*;
import site.minnan.apimanager.userinterface.response.ResponseEntity;

import javax.validation.Valid;

@Api(tags = "项目")
@RequestMapping("/apiManager/project")
@RestController
@Slf4j
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PreAuthorized
    @ApiOperation("添加项目")
    @PostMapping("addProject")
    public ResponseEntity<?> addProject(@RequestBody @Valid AddProjectDTO dto) {
        projectService.addProject(dto);
        return ResponseEntity.success();
    }

    @ApiOperation("查看项目列表")
    @PostMapping("getProjectList")
    public ResponseEntity<ListQueryVO<ProjectListVO>> getProjectList(@RequestBody @Valid GetProjectListDTO dto) {
        ListQueryVO<ProjectListVO> vo = projectService.getProjectList(dto);
        return vo.empty() ? ResponseEntity.success(vo, "暂无数据") : ResponseEntity.success(vo);
    }

    @ApiOperation("更新项目")
    @PostMapping("updateProject")
    public ResponseEntity<?> updateProject(@RequestBody @Valid UpdateProjectDTO dto) {
        projectService.updateProject(dto);
        return ResponseEntity.success();
    }

    @ApiOperation("加入项目")
    @PostMapping("joinProject")
    public ResponseEntity<?> joinProject(@RequestBody @Valid JoinProjectDTO dto) {
        projectService.joinProject(dto);
        return ResponseEntity.success();
    }

    @ApiOperation("查询项目详情")
    @PostMapping("getProjectInfo")
    public ResponseEntity<ProjectInfoVO> getProjectInfo(@RequestBody @Valid DetailsQueryDTO dto) {
        ProjectInfoVO vo = projectService.getProjectInfo(dto);
        return ResponseEntity.success(vo);
    }
}
