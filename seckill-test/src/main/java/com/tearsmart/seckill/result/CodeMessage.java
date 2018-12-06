package com.tearsmart.seckill.result;

/**
 * <p>
 *  返回结果中信息类
 * </p>
 * @author tear-smart
 * @date 2018-12-06
 */
public class CodeMessage {
    /**
     * 信息的状态码
     */
    private int code;
    /**
     * 信息内容
     */
    private String message;
    /**
     * 成功
     */
    public static CodeMessage SUCCESS = new CodeMessage(0,"success!");
    /**
     * 服务器异常
     */
    public static CodeMessage SERVER_ERROR = new CodeMessage(500100,"服务端异常!");
    private CodeMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
