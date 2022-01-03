package site.minnan.apimanager.application.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.minnan.apimanager.application.service.ProjectService;
import site.minnan.apimanager.domain.aggregate.Project;
import site.minnan.apimanager.domain.entity.Principal;
import site.minnan.apimanager.domain.mapper.ProjectMapper;
import site.minnan.apimanager.domain.vo.ListQueryVO;
import site.minnan.apimanager.domain.vo.ProjectListVO;
import site.minnan.apimanager.infrastructure.context.UserHolder;
import site.minnan.apimanager.infrastructure.exception.EntityNotExistException;
import site.minnan.apimanager.userinterface.dto.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Minnan on 2022/01/03
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    public ProjectMapper projectMapper;

    /**
     * 添加项目
     *
     * @param dto
     */
    @Override
    public void addProject(AddProjectDTO dto) {
        Project project = Project.builder()
                .projectName(dto.getProjectName())
                .build();
        Principal principal = UserHolder.getPrincipal();
        project.setCreateUser(principal);
        projectMapper.insert(project);
    }

    /**
     * 查询项目列表
     *
     * @param dto
     * @return
     */
    @Override
    public ListQueryVO<ProjectListVO> getProjectList(GetProjectListDTO dto) {
        QueryWrapper<Project> queryWrapper = new QueryWrapper<>();
        Optional.ofNullable(dto.getKeyword()).ifPresent(s -> queryWrapper.like("project_name", s));
        Page<Project> queryPage = new Page<>(dto.getPageIndex(), dto.getPageSize());
        IPage<Project> page = projectMapper.selectPage(queryPage, queryWrapper);
        List<ProjectListVO> list = page.getRecords().stream().map(ProjectListVO::vo).collect(Collectors.toList());
        return new ListQueryVO<>(list, page.getTotal());
    }


    /**
     * 更新项目
     *
     * @param dto
     */
    @Override
    public void updateProject(UpdateProjectDTO dto) {
        Project project = projectMapper.selectById(dto.getId());
        if(project == null){
            throw new EntityNotExistException("项目不存在");
        }
        Principal principal = UserHolder.getPrincipal();
        project.setUpdateUser(principal);
        project.setProjectName(dto.getProjectName());
        projectMapper.updateById(project);
    }

}
