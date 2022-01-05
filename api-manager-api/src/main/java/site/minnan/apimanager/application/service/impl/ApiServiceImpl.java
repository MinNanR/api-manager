package site.minnan.apimanager.application.service.impl;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import site.minnan.apimanager.application.service.ApiService;
import site.minnan.apimanager.domain.aggregate.Api;
import site.minnan.apimanager.domain.entity.ApiModifyHistory;
import site.minnan.apimanager.domain.entity.Principal;
import site.minnan.apimanager.domain.mapper.ApiMapper;
import site.minnan.apimanager.domain.mapper.ApiModifyHistoryMapper;
import site.minnan.apimanager.domain.vo.ApiInfoVO;
import site.minnan.apimanager.domain.vo.ApiListVO;
import site.minnan.apimanager.domain.vo.ApiModifyHistoryVO;
import site.minnan.apimanager.domain.vo.ListQueryVO;
import site.minnan.apimanager.infrastructure.context.UserHolder;
import site.minnan.apimanager.infrastructure.exception.EntityNotExistException;
import site.minnan.apimanager.userinterface.dto.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Minnan on 2022/01/04
 */
@Service
public class ApiServiceImpl implements ApiService {

    @Autowired
    private ApiMapper apiMapper;

    @Autowired
    private ApiModifyHistoryMapper apiModifyHistoryMapper;

    /**
     * 添加接口
     *
     * @param dto
     */
    @Override
    @Transactional
    public void addApi(AddApiDTO dto) {
        String paramString = Optional.ofNullable(dto.getParamList())
                .map(JSONUtil::toJsonStr)
                .orElse("[]");
        String resultString = Optional.ofNullable(dto.getResultList())
                .map(JSONUtil::toJsonStr)
                .orElse("[]");
        Api api = Api.builder()
                .projectId(dto.getProjectId())
                .projectName(dto.getProjectName())
                .apiName(dto.getApiName())
                .url(dto.getUrl())
                .method(dto.getMethod())
                .comment(dto.getComment())
                .headers(dto.getHeaders())
                .param(paramString)
                .result(resultString)
                .build();
        Principal principal = UserHolder.getPrincipal();
        api.setCreateUser(principal);
        apiMapper.insert(api);

        insertModifyHistory(api, paramString, resultString);
    }

    /**
     * 获取api列表（根据项目）
     *
     * @param dto
     */
    @Override
    public ListQueryVO<ApiListVO> getApiListByProject(GetApiListDTO dto) {
        System.out.println(dto.getProjectId());
        QueryWrapper<Api> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "api_name", "url");
        queryWrapper.eq("project_id", dto.getProjectId());
        List<Api> apiList = apiMapper.selectList(queryWrapper);
        List<ApiListVO> voList = apiList.stream().map(ApiListVO::of).collect(Collectors.toList());
        return new ListQueryVO<>(voList, null);
    }

    /**
     * 获取api相信信息
     *
     * @param dto
     * @return
     */
    @Override
    public ApiInfoVO getApiInfo(DetailsQueryDTO dto) {
        Api api = apiMapper.selectById(dto.getId());
        if(api == null){
            throw new EntityNotExistException("接口不存在");
        }
        return new ApiInfoVO(api);
    }

    /**
     * 更新接口
     *
     * @param dto
     */
    @Override
    @Transactional
    public void updateApi(UpdateApiDTO dto) {
        Api api = apiMapper.selectById(dto.getId());
        if(api == null){
            throw new EntityNotExistException("接口不存在");
        }
        api.setApiName(dto.getApiName());
        api.setUrl(dto.getUrl());
        api.setHeaders(dto.getHeaders());
        api.setComment(dto.getComment());
        String paramString = Optional.ofNullable(dto.getParamList()).map(JSONUtil::toJsonStr).orElse("[]");
        String resultString = Optional.ofNullable(dto.getResultList()).map(JSONUtil::toJsonStr).orElse("[]");
        api.setParam(paramString);
        api.setResult(resultString);
        api.setUpdateUser(UserHolder.getPrincipal());
        apiMapper.updateById(api);

        insertModifyHistory(api, paramString, resultString);
    }

    /**
     * 获取接口修改记录
     *
     * @param dto
     * @return
     */
    @Override
    public ListQueryVO<ApiModifyHistoryVO> getApiModifyHistory(@RequestBody @Valid GetApiModifyHistoryListDTO dto) {
        Integer totalCount = apiModifyHistoryMapper.countByApiId(dto.getId());
        List<ApiModifyHistoryVO> list = apiModifyHistoryMapper.getApiModifyHistory(dto);
        return new ListQueryVO<>(list, totalCount);
    }

    /**
     * 添加接口修改历史
     *
     * @param api          接口对象
     * @param paramString  参数列表JSON字符串
     * @param resultString 返回值列表JSON字符串
     */
    private void insertModifyHistory(Api api, String paramString, String resultString) {
        Principal principal = UserHolder.getPrincipal();
        Integer apiId = api.getId();
        ApiModifyHistory modifyHistory = ApiModifyHistory.builder()
                .apiId(apiId)
                .apiName(api.getApiName())
                .url(api.getUrl())
                .method(api.getMethod())
                .headers(api.getHeaders())
                .comment(api.getComment())
                .build();
        modifyHistory.setCreateUser(principal);
        apiModifyHistoryMapper.insert(modifyHistory);

        Integer modifyHistoryId = modifyHistory.getId();
        apiModifyHistoryMapper.insertApiParamHistory(apiId, modifyHistoryId, paramString);
        apiModifyHistoryMapper.insertApiResultHistory(apiId, modifyHistoryId, resultString);
    }

}
