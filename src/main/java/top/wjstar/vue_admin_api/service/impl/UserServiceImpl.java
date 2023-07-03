package top.wjstar.vue_admin_api.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.wjstar.vue_admin_api.common.Constants;
import top.wjstar.vue_admin_api.dto.LoginDto;
import top.wjstar.vue_admin_api.entity.User;
import top.wjstar.vue_admin_api.exception.ServiceException;
import top.wjstar.vue_admin_api.mapper.UserMapper;
import top.wjstar.vue_admin_api.service.IUserService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wxvirus
 * @since 2023-07-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public LoginDto login(LoginDto loginDto) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", loginDto.getUsername());
        queryWrapper.eq("password", loginDto.getPassword());
        User one = getOne(queryWrapper);
        if (one == null) {
            throw new ServiceException(Constants.USER_NOT_EXISTS.getCode(), Constants.USER_NOT_EXISTS.getMsg());
        }

        BeanUtil.copyProperties(one, loginDto, true);

        return loginDto;
    }
}
