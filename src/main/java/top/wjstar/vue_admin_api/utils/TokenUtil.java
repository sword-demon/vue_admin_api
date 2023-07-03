package top.wjstar.vue_admin_api.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.wjstar.vue_admin_api.entity.User;
import top.wjstar.vue_admin_api.service.IUserService;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@Slf4j
public class TokenUtil {

    private static IUserService staticUserService;
    @Resource
    private IUserService userService;

    @PostConstruct
    public void init() {
        staticUserService = userService;
    }

    public static String genToken(User user) {
        return JWT.create().withAudience(user.getId().toString())
                // 2小时 token 过期
                .withExpiresAt(DateUtil.offsetHour(new Date(), 2))
                .sign(Algorithm.HMAC256(user.getPassword()));
    }

    public static User getCurrentUser() {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String token = request.getHeader("token");
            if (StrUtil.isEmpty(token)) {
                return null;
            }
            String aud = JWT.decode(token).getAudience().get(0);
            Integer userId = Integer.valueOf(aud);
            return staticUserService.getById(userId);
        } catch (Exception e) {
            log.error("解析 token 失败", e);
            return null;
        }
    }
}
