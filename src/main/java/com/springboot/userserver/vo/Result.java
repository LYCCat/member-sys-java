package com.springboot.userserver.vo;


public class Result<T> {
    private int code;    // 状态码（如200成功，500失败）
    private String msg;  // 提示信息
    private T data;      // 返回数据

    public Result() {

    }

    // 静态工厂方法
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "success", data);
    }

    public static <T> Result<T> error(String message) {
        Result<T> result = new Result<>();
        result.code = 500;
        result.msg = message;
        return result;
    }
    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public static Result<Void> success() {
        return new Result<>(200, "success", null);
    }




    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
