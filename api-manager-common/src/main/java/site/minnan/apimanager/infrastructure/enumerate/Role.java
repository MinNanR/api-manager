package site.minnan.apimanager.infrastructure.enumerate;


import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {

    ADMIN("MALE", "男"),
    USER("FEMALE", "女");

    @EnumValue
    private final String value;

    @JsonValue
    private final String roleName;

    Role(String value, String roleName) {
        this.value = value;
        this.roleName = roleName;
    }

    public String getValue(){
        return value;
    }

    public String getRoleName(){
        return roleName;
    }
}
