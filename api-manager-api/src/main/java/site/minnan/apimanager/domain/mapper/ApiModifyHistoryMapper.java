package site.minnan.apimanager.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import site.minnan.apimanager.domain.entity.ApiModifyHistory;
import site.minnan.apimanager.domain.vo.ApiModifyHistoryVO;
import site.minnan.apimanager.userinterface.dto.GetApiModifyHistoryListDTO;

import java.util.List;

/**
 * @author Minnan on 2022/01/05
 */
@Mapper
@Repository
public interface ApiModifyHistoryMapper extends BaseMapper<ApiModifyHistory> {

    /**
     * 添加参数修改记录
     *
     * @param apiId              接口id
     * @param apiModifyHistoryId 修改记录id
     * @param paramContent       参数内容
     */
    void insertApiParamHistory(@Param("apiId") Integer apiId, @Param("apiModifyHistoryId") Integer apiModifyHistoryId,
                               @Param("paramContent") String paramContent);

    /**
     * 添加返回结果修改记录
     *
     * @param apiId              接口id
     * @param apiModifyHistoryId 修改记录id
     * @param resultContent      参数内容
     */
    void insertApiResultHistory(@Param("apiId") Integer apiId, @Param("apiModifyHistoryId") Integer apiModifyHistoryId,
                                @Param("resultContent") String resultContent);

    /**
     * 查询接口修改记录
     *
     * @param dto 查询参数
     * @return
     */
    List<ApiModifyHistoryVO> getApiModifyHistory(GetApiModifyHistoryListDTO dto);

    @Select("select count(1) from api_modify_history where api_id = #{apiId}")
    Integer countByApiId(@Param("apiId") Integer apiId);
}
