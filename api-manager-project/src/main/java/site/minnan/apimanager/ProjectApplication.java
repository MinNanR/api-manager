package site.minnan.apimanager;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 *
 * @author Minnan on 2021/12/31
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2Doc
//@ComponentScan(basePackages={"cn.hutool.extra.spring"})
@Import(cn.hutool.extra.spring.SpringUtil.class)
@MapperScan("site.minnan.apimanager.domain.mapper")
public class ProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }
}
