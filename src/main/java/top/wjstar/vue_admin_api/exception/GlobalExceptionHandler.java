package top.wjstar.vue_admin_api.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.wjstar.vue_admin_api.common.Result;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public Result handle(ServiceException se) {
        return Result.error(se.getCode(), se.getMessage());
    }
}
