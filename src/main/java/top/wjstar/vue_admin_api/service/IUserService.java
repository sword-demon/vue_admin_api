package top.wjstar.vue_admin_api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.wjstar.vue_admin_api.dto.LoginDto;
import top.wjstar.vue_admin_api.entity.User;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wxvirus
 * @since 2023-07-02
 */
public interface IUserService extends IService<User> {

    LoginDto login(LoginDto loginDto);
}
