package site.minnan.apimanager.application.provider;

import cn.hutool.http.HttpUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("api-manager-auth")
public interface DocsProvider {

    @RequestMapping("/v2/api-docs")
    public String getDocs();
}
