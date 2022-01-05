package site.minnan.apimanager.infrastructure.enumerate;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum ApiStatus {

    USING(1,"正在使用"),
    RECORDED(2, "历史记录");

    @EnumValue
    private final Integer value;

    private final String status;

    ApiStatus(Integer value, String status) {
        this.value = value;
        this.status = status;
    }

    public Integer getValue() {
        return value;
    }

    public String getStatus() {
        return status;
    }
}
