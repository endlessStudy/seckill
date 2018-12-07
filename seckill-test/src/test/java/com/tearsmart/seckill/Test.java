package com.tearsmart.seckill;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Random;

/**
 * <p>
 *
 * </p>
 * @author tear-smart
 * @date 2018-12-07
 */
public class Test {
    public static void main(String[] args) {

        System.out.println(DigestUtils.md5Hex("a"));
        System.out.println(DigestUtils.md5Hex("A"));
    }
}
