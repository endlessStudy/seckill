package com.tearsmart.seckill.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tearsmart.seckill.domain.User;
import com.tearsmart.seckill.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.MapUtils;

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
    public void get() {
        Map<String ,String> map = new HashMap();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(i);
            user.setName("tear-smart" + i);
            map.put("user" + i, JSONObject.toJSONString(user));
        }
        System.out.println(map.size());

        hashOperations.put("hash","user","user1");
        hashOperations.putAll("map",map);
    }

}
