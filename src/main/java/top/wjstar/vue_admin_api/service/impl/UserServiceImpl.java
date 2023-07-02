package top.wjstar.vue_admin_api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.wjstar.vue_admin_api.entity.User;
import top.wjstar.vue_admin_api.mapper.UserMapper;
import top.wjstar.vue_admin_api.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
