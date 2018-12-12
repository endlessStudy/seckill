package com.tearsmart.seckill.service;

import com.tearsmart.seckill.domain.MiaoshaUser;
import com.tearsmart.seckill.redis.BasePrefix;

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
     * @param prefix
     * @param key
     * @param clazz
     * @param <T>
     */
    <T> T get(BasePrefix prefix,String key,Class<T> clazz);

    /**
     * redis添加数据
     * @param prefix redis key前缀
     * @param key
     * @param value
     */
     <V> boolean set(BasePrefix prefix, String key, V value);
}
