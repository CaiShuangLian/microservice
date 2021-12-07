package com.csl.springcloud.common;

public enum CodeEnum {
    // 通用错误码
    SUCCESS(200, "success"),
    SERVER_ERROR(50000, "服务端异常"),
    REMOTE_ERROR(50001, "远程调用异常，正在熔断处理，请稍后！"),
    PARAMETER_VALIDATION_ERROR(50002, "参数校验异常，请检查！");


    private Integer code;
    private String msg;


    CodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "BziCodeEnum{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
