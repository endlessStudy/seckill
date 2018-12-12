package com.tearsmart.seckill.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.tearsmart.seckill.redis.BasePrefix;
import com.tearsmart.seckill.service.IRedisService;
import com.tearsmart.seckill.util.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * redis服务实现类
 * </p>
 * @author tear-smart
 * @date 2018-12-06
 */
@Service
public class RedisServiceImpl implements IRedisService {
    @Autowired
    private StringRedisTemplate srTemplate;
    @Resource
    private HashOperations hashOperations;

    @Override
    public <T> T get(BasePrefix prefix, String key, Class<T> clazz) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        String realKey = prefix.getPrefix() + ":"+key;
        String result = srTemplate.opsForValue().get(realKey);
        T t = (T) JSONUtils.jsonToBean(result, clazz);
        return t;
    }

    /**
     * redis添加数据
     * @param prefix
     * @param key
     * @param value
     */
    @Override
    public <V> boolean set(BasePrefix prefix, String key, V value) {
        String data = JSONUtils.beanToJson(value);
        if (data == null || data.length() == 0) {
            return false;
        }
        int expire = prefix.expireSeconds();
        String realKey = prefix.getPrefix() + ":" +key;
        if (expire == BasePrefix.NO_EXPIRE) {
            srTemplate.opsForValue().set(key, data);
        } else {
            srTemplate.opsForValue().set(realKey, data, expire, TimeUnit.SECONDS);
        }
        return true;
    }

}
