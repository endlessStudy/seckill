package com.tearsmart.seckill.service.impl;

import com.tearsmart.seckill.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * <p>
 * redis 服务s实现类
 * </p>
 * @author tear-smart
 * @date 2018-12-06
 */
@Service
public class RedisServiceImpl implements IRedisService {
    @Autowired
    private StringRedisTemplate srTemplate;
    @Override
    public void get() {
        srTemplate.opsForValue().set("name","tear-smart");
    }
}
