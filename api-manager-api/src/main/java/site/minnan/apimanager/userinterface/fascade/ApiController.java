package site.minnan.apimanager.userinterface.fascade;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.minnan.apimanager.application.service.ApiService;
import site.minnan.apimanager.domain.vo.ApiInfoVO;
import site.minnan.apimanager.domain.vo.ApiListVO;
import site.minnan.apimanager.domain.vo.ApiModifyHistoryVO;
import site.minnan.apimanager.domain.vo.ListQueryVO;
import site.minnan.apimanager.userinterface.dto.*;
import site.minnan.apimanager.userinterface.response.ResponseEntity;

import javax.validation.Valid;

/**
 * @author Minnan on 2022/01/04
 */
@Api(tags = "接口")
@RestController
@RequestMapping("/apiManager/api")
public class ApiController {

    @Autowired
    private ApiService apiService;

    /**
     * 添加接口
     *
     * @param dto
     * @return
     */
    @ApiOperation("添加接口")
    @PostMapping("addApi")
    public ResponseEntity<?> addApi(@RequestBody @Valid AddApiDTO dto) {
        apiService.addApi(dto);
        return ResponseEntity.success();
    }

    /**
     * 获取接口列表（根据项目）
     *
     * @param dto
     * @return
     */
    @ApiOperation("获取接口列表（根据项目）")
    @PostMapping("getApiList")
    public ResponseEntity<ListQueryVO<ApiListVO>> getApiList(@RequestBody @Valid GetApiListDTO dto) {
        ListQueryVO<ApiListVO> vo = apiService.getApiListByProject(dto);
        return vo.empty() ? ResponseEntity.success(vo, "暂无数据") : ResponseEntity.success(vo);
    }

    /**
     * 获取接口详情
     *
     * @param dto
     * @return
     */
    @ApiOperation("获取接口详情")
    @PostMapping("getApiInfo")
    public ResponseEntity<ApiInfoVO> getApiInfo(@RequestBody @Valid DetailsQueryDTO dto) {
        ApiInfoVO apiInfo = apiService.getApiInfo(dto);
        return ResponseEntity.success(apiInfo);
    }

    /**
     * 更新接口
     *
     * @param dto
     * @return
     */
    @ApiOperation("更新接口")
    @PostMapping("updateApi")
    public ResponseEntity<?> updateApi(@RequestBody @Valid UpdateApiDTO dto) {
        apiService.updateApi(dto);
        return ResponseEntity.success();
    }

    /**
     * 获取接口修改记录
     *
     * @param dto
     * @return
     */
    @ApiOperation("获取接口修改记录")
    @PostMapping("getApiModifyHistoryList")
    public ResponseEntity<ListQueryVO<ApiModifyHistoryVO>> getApiModifyHistoryList(@RequestBody @Valid GetApiModifyHistoryListDTO dto) {
        ListQueryVO<ApiModifyHistoryVO> vo = apiService.getApiModifyHistory(dto);
        return ResponseEntity.success(vo);
    }
}
