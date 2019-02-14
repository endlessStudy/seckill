package com.tearsmart.seckill.controller;

import com.alibaba.fastjson.JSONObject;
import com.tearsmart.seckill.domain.User;
import com.tearsmart.seckill.service.impl.AsyncServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * <p>
 *
 * </p>
 * @author tear-smart
 * @date 2019-01-14
 */
@Controller
public class UploadController {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    AsyncServiceImpl service;
    @RequestMapping("async")
    @ResponseBody
    public String async() throws Exception {
        Integer integer = new Integer(1);
        Future<String> future = service.asyncInvokeReturnFuture(4000);
        return future.get();
    }
    @RequestMapping("/upload")
    public void test(@RequestParam(value = "file") MultipartFile[] file){
        for (MultipartFile multipartFile : file) {
            System.out.println(multipartFile.getName());
        }
        System.out.println("1111");
        System.out.println("1111");
    }

    @RequestMapping("/set")
    @ResponseBody
    public Object redis(){
        Long increment = redisTemplate.opsForValue().increment("increment", 1);
        return increment;
    }
    @RequestMapping("/get")
    @ResponseBody
    public Object getRedis(){
        String string = redisTemplate.opsForValue().get("user");
        User user = JSONObject.parseObject(string, User.class);
        return user;

    }
}
