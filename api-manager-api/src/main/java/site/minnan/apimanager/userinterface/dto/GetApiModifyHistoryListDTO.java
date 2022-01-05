package site.minnan.apimanager.userinterface.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import site.minnan.apimanager.domain.vo.ListQueryVO;

/**
 * 获取接口修改记录参数
 *
 * @author Minnan on 2022/01/05
 */
@ApiModel("获取接口修改记录参数")
@Data
public class GetApiModifyHistoryListDTO extends ListQueryDTO {

    private Integer id;
}
