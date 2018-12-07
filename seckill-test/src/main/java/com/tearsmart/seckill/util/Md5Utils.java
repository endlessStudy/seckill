package com.tearsmart.seckill.util;


import org.apache.commons.codec.digest.DigestUtils;

import java.util.Random;

/**
 * <p>
 * 密码进行二次加密 随机 salt + md5
 * </p>
 * @author tear-smart
 * @date 2018-12-07
 */
public class Md5Utils {
    /**
     * 对字符串进行md5加密
     * @return
     */
    private String encryption(String string) {
        return DigestUtils.md5Hex(string);
    }

    /**
     * 对前台传过来的密码,进行一次加密.
     * @param cipherPwd 密文密码
     * @return 一次加密的密码
     */
    private String encryFirst(String cipherPwd) {
        String salt = randomSalt();
        String pwd = salt.charAt(0) + salt.charAt(2) + cipherPwd + salt.charAt(4) + salt.charAt(6);
        return encryption(pwd);
    }

    /**
     * 对前台传过来的密码,进行第二次加密.
     * @param cipherPwd 密文密码
     * @return 二次加密的密码
     */
    private String encrySecond(String cipherPwd, String salt) {
        String pwd = salt.charAt(0) + salt.charAt(2) + cipherPwd + salt.charAt(4) + salt.charAt(6);
        return encryption(pwd);
    }

    /**
     * 返回要存入数据库中的密码
     * @param cipherPwd 密文密码
     * @return 存入数据库中的密码
     */
    private Object dbEncry(String cipherPwd) {
        String salt = randomSalt();
        return encrySecond(encryFirst(cipherPwd), salt);
    }

    /**
     * 生成随机加密盐
     * @return 加密盐
     */
    private String randomSalt() {
        String saltRoot = "ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(saltRoot.charAt(random.nextInt(62)));
        }
        return stringBuilder.toString();
    }
}
