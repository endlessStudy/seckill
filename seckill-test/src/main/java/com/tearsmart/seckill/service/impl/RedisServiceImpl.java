package com.tearsmart.seckill.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tearsmart.seckill.domain.User;
import com.tearsmart.seckill.service.IRedisService;
import com.tearsmart.seckill.util.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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
    public <T> void get(String key,Class<T> clazz) {

    }

    /**
     * redis添加数据
     * @param prefix
     * @param key
     * @param value
     */
    @Override
    public <V> void set(String prefix,String key, V value) {
        String redisKey = "";
       srTemplate.opsForValue().set(key, JSONUtils.beanToJson(value));
    }

}
