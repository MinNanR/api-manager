package site.minnan.apimanager.userinterface.fascade;

import cn.hutool.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import site.minnan.apimanager.application.provider.DocsProvider;

import java.util.ArrayList;


@Controller
public class SwaggerController {

    @Autowired
    private DocsProvider docsProvider;

    @RequestMapping("/v2/api-docs")
    @ResponseBody
    public Object apidocs() {
        return docsProvider.getDocs();
    }

    @RequestMapping("/swagger-resources/configuration/ui")
    @ResponseBody
    public String ui() {
        return "{\"deepLinking\":true,\"displayOperationId\":false,\"defaultModelsExpandDepth\":1,\"defaultModelExpandDepth\":1,\"defaultModelRendering\":\"example\",\"displayRequestDuration\":false,\"docExpansion\":\"none\",\"filter\":false,\"operationsSorter\":\"alpha\",\"showExtensions\":false,\"tagsSorter\":\"alpha\",\"validatorUrl\":\"\",\"apisSorter\":\"alpha\",\"jsonEditor\":false,\"showRequestHeaders\":false,\"supportedSubmitMethods\":[\"get\",\"put\",\"post\",\"delete\",\"options\",\"head\",\"patch\",\"trace\"]}";
    }

    @RequestMapping("/swagger-ui.html/swagger-resources/configuration/security")
    @ResponseBody
    public String security(){
        return "{}";
    }

    @RequestMapping("/swagger-resources")
    @ResponseBody
    public String resources(){
        return "[{\"name\":\"default\",\"url\":\"/v2/api-docs\",\"swaggerVersion\":\"2.0\",\"location\":\"/v2/api-docs\"}]";
    }


}
