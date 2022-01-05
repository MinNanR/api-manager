package site.minnan.apimanager.domain.aggregate;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import site.minnan.apimanager.domain.entity.ModifiableEntity;
import site.minnan.apimanager.domain.entity.Principal;
import site.minnan.apimanager.infrastructure.enumerate.ApiStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 接口对象
 *
 * @author Minnan on 2022/01/04
 */
@TableName("api")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Api extends ModifiableEntity {

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 项目id
     */
    private Integer projectId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 接口名称
     */
    private String apiName;

    /**
     * 接口地址
     */
    private String url;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 所需请求头
     */
    private Map<String, String> headers;

    /**
     * 接口特殊说明
     */
    private String comment;

    /**
     * 参数(JSON）
     */
    private String param;

    /**
     * 返回值（JSON）
     */
    private String result;

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public void setHeaders(String headersString) {
        HashMap map = JSONUtil.toBean(headersString, HashMap.class);
        setHeaders(map);
    }

    public void setCreateUser(Principal principal) {
        super.setCreateUser(principal.getUserId(), principal.getRealName());
    }

    public void setUpdateUser(Principal principal) {
        super.setUpdateUser(principal.getUserId(), principal.getRealName());
    }
}
