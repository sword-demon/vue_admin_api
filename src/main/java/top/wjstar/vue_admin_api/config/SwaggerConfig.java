package top.wjstar.vue_admin_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    /**
     * 创建 API 应用
     * apiInfo 增加 API 相关信息
     *
     * @return
     */
    @Bean
    public Docket restApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("标准接口")
                .apiInfo(apiInfo("SpringBoot 使用 swagger 构建restful api", "1.0"))
                .useDefaultResponseMessages(true)
                .forCodeGeneration(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("top.wjstar.vue_admin_api.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 创建 APi的基本信息
     * <p>
     * 访问地址: http://ip:port/swagger-ui/index.html
     *
     * @param title
     * @param version
     * @return
     */
    private ApiInfo apiInfo(String title, String version) {
        return new ApiInfoBuilder()
                .title(title)
                .description("无解的游戏vue 前后端分离权限管理系统")
                .termsOfServiceUrl("https://www.wjstar.top")
                .contact(new Contact("wujie", "wujie", "wujie@qq.com"))
                .version(version)
                .build();
    }
}
