package top.wjstar.vue_admin_api.intereceptor;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import top.wjstar.vue_admin_api.common.Constants;
import top.wjstar.vue_admin_api.entity.User;
import top.wjstar.vue_admin_api.exception.ServiceException;
import top.wjstar.vue_admin_api.service.IUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Resource
    private IUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 从 http 请求头获取 token
        String token = request.getHeader("token");

        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        // 执行认证
        if (StrUtil.isEmpty(token)) {
            throw new ServiceException(Constants.UN_AUTHORIZATION.getCode(), Constants.UN_AUTHORIZATION.getMsg());
        }
        // 获取 token 里的数据
        String userId;
        try {
            userId = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException e) {
            e.printStackTrace();
            log.error("解析 token 失败, token = [{}]", token, e);
            throw new ServiceException(Constants.UN_AUTHORIZATION.getCode(), Constants.UN_AUTHORIZATION.getMsg());
        }
        User user = userService.getById(Integer.valueOf(userId));
        if (user == null) {
            throw new ServiceException(Constants.USER_NOT_EXISTS.getCode(), Constants.USER_NOT_EXISTS.getMsg());
        }

        // 验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            log.error("jwt 验证 token 失败", e);
            throw new ServiceException(Constants.TOKEN_VALID.getCode(), Constants.TOKEN_VALID.getMsg());
        }

        return true;
    }
}
