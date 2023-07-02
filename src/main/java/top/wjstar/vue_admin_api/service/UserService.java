package top.wjstar.vue_admin_api.service;

import org.springframework.stereotype.Service;
import top.wjstar.vue_admin_api.entity.User;
import top.wjstar.vue_admin_api.mapper.UserMapper;

@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public int save(User user) {
        if (user.getId() == null) {
            // 新增
            return userMapper.addUser(user);
        } else {
            return userMapper.updateUser(user);
        }
    }
}
