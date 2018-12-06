package com.tearsmart.seckill.result;

/**
 * <p>
 * 统一的返回结果格式
 * </p>
 * @author tear-smart
 * @date 2018-12-05
 */
public class Result<T> {
    /**
     * 状态码
     */
    private int code;
    /**
     * 状态信息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;

    public Result(CodeMessage codeMessage) {
        if (codeMessage == null) {
            return;
        }
        this.code = codeMessage.getCode();
        this.message = codeMessage.getMessage();
    }

    private Result(T data) {
        this.code = 200;
        this.message = "SUCCESS!";
        this.data = data;
    }

    /**
     * 成功时,结果返回方法
     * @param data 返回结果中包含的数据
     * @return 通用返回值
     */
    public static <T>Result<T> success(T data) {
        return new Result(data);
    }

    /**
     * 失败时,结果返回方法
     * @param codeMessage 信息编码类
     * @return 通用返回值
     */
    public static <T> Result<T> error(CodeMessage codeMessage) {
        return new Result<T>(codeMessage);
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
