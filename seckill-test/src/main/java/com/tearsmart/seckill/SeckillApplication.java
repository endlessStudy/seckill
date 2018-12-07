package com.tearsmart.seckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
  * <p>
  *     项目启动类
  * </p>
  * @author tear-smart
  * @date 2018/12/5 14:39
  */
@MapperScan(basePackages = "com.tearsmart.seckill.dao")
@SpringBootApplication
public class SeckillApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillApplication.class, args);
    }
    @Autowired
    StringRedisTemplate redisTemplate;
    @Bean
    public HashOperations<String, String, Object> hashOperations() {
        return redisTemplate.opsForHash();
    }
}
