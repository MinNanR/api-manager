package site.minnan.apimanager.infrastructure.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "swagger-doc")
public class SwaggerDocConfig {

    private Map<String, String> doc;

    public void setDoc(Map<String, String> doc) {
        this.doc = doc;
    }

    public Map<String, String> getDoc() {
        return doc;
    }
}
