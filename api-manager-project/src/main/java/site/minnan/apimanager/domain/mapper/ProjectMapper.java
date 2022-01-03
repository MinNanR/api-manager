package site.minnan.apimanager.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import site.minnan.apimanager.domain.aggregate.Project;

/**
 * 项目数据库操作mapper
 *
 * @author Minnan on 2022/01/03
 */
@Mapper
@Repository
public interface ProjectMapper extends BaseMapper<Project> {
}
