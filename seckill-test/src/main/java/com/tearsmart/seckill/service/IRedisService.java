package com.tearsmart.seckill.service;

import com.tearsmart.seckill.domain.MiaoshaUser;

/**
 * <p>
 * redis 服务类
 * </p>
 * @author tear-smart
 * @date 2018-12-06
 */
public interface IRedisService {
    /**
     * 从redis中取出数据
     * @param key
     * @param clazz
     * @param <T>
     */
    <T> void get(String key,Class<T> clazz);

    /**
     * redis添加数据
     * @param prefix redis key前缀
     * @param key
     * @param value
     */
     <V> void set(String prefix,String key, V value);
}
