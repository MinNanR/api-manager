package site.minnan.apimanager.application.service;

import site.minnan.apimanager.domain.aggregate.Api;
import site.minnan.apimanager.domain.entity.ApiModifyHistory;
import site.minnan.apimanager.domain.vo.ApiInfoVO;
import site.minnan.apimanager.domain.vo.ApiListVO;
import site.minnan.apimanager.domain.vo.ApiModifyHistoryVO;
import site.minnan.apimanager.domain.vo.ListQueryVO;
import site.minnan.apimanager.userinterface.dto.*;

import java.util.List;

/**
 * 接口相关
 *
 * @author Minnan on 2022/01/04
 */
public interface ApiService {

    /**
     * 添加接口
     *
     * @param dto
     */
    void addApi(AddApiDTO dto);

    /**
     * 获取接口列表（根据项目）
     *
     * @param dto
     */
    ListQueryVO<ApiListVO> getApiListByProject(GetApiListDTO dto);

    /**
     * 获取接口相信信息
     *
     * @param dto
     * @return
     */
    ApiInfoVO getApiInfo(DetailsQueryDTO dto);

    /**
     * 更新接口
     *
     * @param dto
     */
    void updateApi(UpdateApiDTO dto);

    /**
     * 获取接口修改记录
     *
     * @return
     */
    ListQueryVO<ApiModifyHistoryVO> getApiModifyHistory(GetApiModifyHistoryListDTO dto);
}
