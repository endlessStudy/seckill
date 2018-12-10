package com.tearsmart.seckill.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * 参数验证工具类
 * </p>
 * @author tear-smart
 * @date 2018-12-09
 */
public class ValidatorUtils {
    /**
     * 手机号码验证正则表达式
     */
    private static String PHONE_REGEX = "1\\d{10}";
    private static Pattern pattern = Pattern.compile(PHONE_REGEX);

    /**
     * 电话号码验证
     */
    public static boolean mobileValidator(String phone) {
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(mobileValidator("15038344602"));
        System.out.println(mobileValidator("150384460"));
    }
}
