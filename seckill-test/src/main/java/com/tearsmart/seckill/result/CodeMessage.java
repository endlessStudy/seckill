package com.tearsmart.seckill.result;

/**
 * <p>
 * 返回结果中信息类
 * </p>
 * @author tear-smart
 * @date 2018-12-06
 */
public class CodeMessage {


    /**
     * 成功
     */
    public static final CodeMessage SUCCESS = new CodeMessage(0, "success!");
    /**
     * 5001xx
     * 服务器异常
     */
    public static final CodeMessage SERVER_ERROR = new CodeMessage(500100, "服务端异常!");
    public static final CodeMessage BIND_EXCEPTION = new CodeMessage(500100, "参数校验异常: %s");
    /**
     * 登录相关异常  5002xx
     * <p>
     * 密码不能为空
     */
    public static final CodeMessage PASSWORD_EMPTY = new CodeMessage(500200, "密码不能为空!");
    /**
     * 电话号码不能为空
     */
    public static final CodeMessage PHONE_EMPTY = new CodeMessage(500201, "电话号码不能为空!");
    /**
     * 电话号码不能为空
     */
    public static final CodeMessage PHONE_FORMAT_ERROR = new CodeMessage(500201, "电话号码格式错误!");
    /**
     * 电话号码不能为空
     */
    public static final CodeMessage USER_NOT_EXIST = new CodeMessage(500201, "帐号不存在!");
    /**
     * 密码错误
     */
    public static final CodeMessage PASSWORD_ERROR = new CodeMessage(500201, "密码错误!");
    //秒杀模块 5005xx
     /**
     * 库存为零
     */
    public static final CodeMessage STOCK_ZERO   = new CodeMessage(500501, "商品已被秒杀完!");
    public static final CodeMessage REPEAT_ERROR   = new CodeMessage(500501, "您已秒杀成功 ,请勿重复秒杀!");

    /**
     * 信息的状态码
     */
    private int code;
    /**
     * 信息内容
     */
    private String message;

    private CodeMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public CodeMessage fillArgs(Object... param) {
        int code = this.code;
        String message = String.format(this.message, param);
        return new CodeMessage(code, message);
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
