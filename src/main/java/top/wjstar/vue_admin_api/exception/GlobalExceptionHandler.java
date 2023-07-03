package top.wjstar.vue_admin_api.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.wjstar.vue_admin_api.common.Constants;
import top.wjstar.vue_admin_api.common.Result;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public Result handle(ServiceException se) {
        return Result.error(se.getCode(), se.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        log.error("Exception异常", e);
        return Result.error(Constants.ERROR.getCode(), Constants.ERROR.getMsg());
    }
}
