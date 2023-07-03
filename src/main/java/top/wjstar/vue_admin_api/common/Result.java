package top.wjstar.vue_admin_api.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公共响应结果集
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private String code;
    private String msg;
    private Object data;

    public static Result success() {
        return new Result(Constants.SUCCESS.getCode(), Constants.SUCCESS.getMsg(), null);
    }

    public static Result success(Object data) {
        return new Result(Constants.SUCCESS.getCode(), Constants.SUCCESS.getMsg(), data);
    }

    public static Result error(String code, String msg) {
        return new Result(code, msg, null);
    }

    public static Result error() {
        return new Result(Constants.ERROR.getCode(), Constants.ERROR.getMsg(), null);
    }
}
