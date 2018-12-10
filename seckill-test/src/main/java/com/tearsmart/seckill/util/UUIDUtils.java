package com.tearsmart.seckill.util;

import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;

import java.util.UUID;

/**
 * <p>
 *  生成uuid
 * </p>
 * @author tear-smart
 * @date 2018-12-10
 */
public class UUIDUtils {

    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    public static void main(String[] args) {
        System.out.println(getId());
    }
}
