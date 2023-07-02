package top.wjstar.vue_admin_api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.wjstar.vue_admin_api.mapper")
public class VueAdminApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VueAdminApiApplication.class, args);
    }

}
