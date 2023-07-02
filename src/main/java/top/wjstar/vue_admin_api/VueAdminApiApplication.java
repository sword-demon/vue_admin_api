package top.wjstar.vue_admin_api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@MapperScan("top.wjstar.vue_admin_api.mapper")
@EnableOpenApi
public class VueAdminApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VueAdminApiApplication.class, args);
    }

}
