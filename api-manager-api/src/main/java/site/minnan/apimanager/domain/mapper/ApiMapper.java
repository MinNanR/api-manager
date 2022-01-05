package site.minnan.apimanager.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import site.minnan.apimanager.domain.aggregate.Api;
import site.minnan.apimanager.domain.entity.Principal;
import site.minnan.apimanager.userinterface.dto.AddApiDTO;

/**
 * @author Minnan on 2022/01/04
 */
@Mapper
@Repository
public interface ApiMapper extends BaseMapper<Api> {
}
