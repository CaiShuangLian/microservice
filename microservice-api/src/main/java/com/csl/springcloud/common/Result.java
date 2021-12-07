package com.csl.springcloud.common;

/**
 * 返回结果封装
 */
public class Result<T> {
    //状态码，返回信息，返回数据
    private Integer code;
    private String msg;
    private T data;

    public static <T> Result<T> ok() {
        return new Result<T>(CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
    }

    public static <T> Result<T> ok(T data) {
        return new Result<T>(CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg(), data);
    }

    public static <T> Result<T> error() {
        return new Result<T>(CodeEnum.SERVER_ERROR.getCode(), CodeEnum.SERVER_ERROR.getMsg());
    }

    public static <T> Result<T> error(int code, String msg) {
        return new Result<T>(code, msg);
    }


    public Result() {

    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
