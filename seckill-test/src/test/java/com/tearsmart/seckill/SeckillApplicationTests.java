package com.tearsmart.seckill;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tearsmart.seckill.dao.UserMapper;
import com.tearsmart.seckill.domain.User;
import com.tearsmart.seckill.service.IRedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SeckillApplication.class)
public class SeckillApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IRedisService iRedisService;
    @Test
    public void test() {
        User user = userMapper.selectOne(new QueryWrapper<>());
        System.out.println(user);
    }
    @Test
    public void redisTest(){
        iRedisService.get();
    }
}
