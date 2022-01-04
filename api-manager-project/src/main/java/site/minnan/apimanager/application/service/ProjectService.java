package site.minnan.apimanager.application.service;

import site.minnan.apimanager.domain.vo.ListQueryVO;
import site.minnan.apimanager.domain.vo.ProjectInfoVO;
import site.minnan.apimanager.domain.vo.ProjectListVO;
import site.minnan.apimanager.userinterface.dto.*;

/**
 * 项目service
 *
 * @author Minnan on 2021/01/03
 */
public interface ProjectService {

    /**
     * 添加项目
     *
     * @param dto
     */
    void addProject(AddProjectDTO dto);


    /**
     * 查询项目列表
     *
     * @param dto
     * @return
     */
    ListQueryVO<ProjectListVO> getProjectList(GetProjectListDTO dto);

    /**
     * 更新项目
     *
     * @param dto
     */
    void updateProject(UpdateProjectDTO dto);

    /**
     * 加入项目
     *
     * @param dto
     */
    void joinProject(JoinProjectDTO dto);

    /**
     * 查询项目详情
     *
     * @param dto
     * @return
     */
    ProjectInfoVO getProjectInfo(DetailsQueryDTO dto);
}
