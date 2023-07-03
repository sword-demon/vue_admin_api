package top.wjstar.vue_admin_api.common;

public enum Constants {

    SUCCESS("200", "操作成功"),
    ERROR("500", "系统错误"),
    UN_AUTHORIZATION("401", "身份未验证"),
    FORBIDDEN("403", "权限不足"),
    BAD_REQUEST("400", "请求错误"),
    BUSINESS_ERROR("600", "业务异常"),
    USER_NOT_EXISTS("10001", "用户不存在"),
    TOKEN_VALID("99999", "token 验证不合法");

    private String code;
    private String msg;

    Constants(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
