package com.tearsmart.seckill.util;


import org.apache.commons.codec.digest.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * <p>
 * 密码进行二次加密 随机 salt + md5
 * </p>
 * @author tear-smart
 * @date 2018-12-07
 */
public class Md5Utils {
    private static Integer SALT_LENGTH = 8;
    private static String TEST_SALT = "1a2b3c4d";

    /**
     * 对字符串进行md5加密
     * @return
     */
    private static String encryption(String string) {
        return DigestUtils.md5Hex(string);
    }

    public static void main(String[] args) {
        System.out.println(encryption("123456"));
    }

    /**
     * 对前台传过来的密码,进行一次加密.
     * @param cipherPwd 密文密码
     * @return 一次加密的密码
     */
    private static String encryFirst(String cipherPwd, String salt) {
        String pwd = salt.charAt(0) + salt.charAt(2) + cipherPwd + salt.charAt(4) + salt.charAt(6);
        return encryption(pwd);
    }

    /**
     * 测试方法
     * @param cipherPwd
     * @return
     */
    public static String testFun(String cipherPwd) {
        String salt = TEST_SALT;
        String pwd = "" + salt.charAt(0) + salt.charAt(2) + cipherPwd + salt.charAt(4) + salt.charAt(6);
        System.out.println(pwd);
        return encryption(pwd);
    }

    /**
     * 对前台传过来的密码,进行第二次加密.
     * @param cipherPwd 密文密码
     * @return 二次加密的密码
     */
    private static String encrySecond(String cipherPwd, String salt) {
        String pwd = salt.charAt(0) + salt.charAt(2) + cipherPwd + salt.charAt(4) + salt.charAt(6);
        return encryption(pwd);
    }

    /**
     * 返回要存入数据库中的密码
     * @param cipherPwd 密文密码
     * @return 存入数据库中的密码
     */
    public static Map<String, String> dbEncry(String cipherPwd) {
        String salt = randomSalt();
        Map<String, String> map = new HashMap<String, String>();
        map.put("pwd", encrySecond(encryFirst(cipherPwd, salt), salt));
        map.put("salt", salt);
        return map;
    }

    /**
     * 返回通过与库中加密盐加密生成的密码
     * @param cipherPwd 密文密码
     * @param salt 库中随机加密盐
     * @return 加密后的密码
     */
    public static String dbEncry(String cipherPwd, String salt) {
        return encrySecond(encryFirst(cipherPwd, salt), salt);
    }

    /**
     * 生成随机加密盐
     * @return 加密盐
     */
    public static String randomSalt() {
        String saltRoot = "ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < SALT_LENGTH; i++) {
            stringBuilder.append(saltRoot.charAt(random.nextInt(62)));
        }
        return stringBuilder.toString();
    }
}
