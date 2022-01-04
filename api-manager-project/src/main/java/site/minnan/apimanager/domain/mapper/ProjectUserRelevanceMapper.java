package site.minnan.apimanager.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import site.minnan.apimanager.domain.entity.ProjectUserRelevance;
import site.minnan.apimanager.domain.vo.ProjectMemberVO;

import java.util.List;

/**
 * @author Minnan on 2022/01/04
 */
@Mapper
@Repository
public interface ProjectUserRelevanceMapper extends BaseMapper<ProjectUserRelevance> {

    /**
     * 获取项目成员
     *
     * @param id 项目id
     * @return
     */
    List<ProjectMemberVO> getProjectMember(@Param("id") Integer id);
}
