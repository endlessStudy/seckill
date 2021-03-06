package com.tearsmart.seckill;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tearsmart.seckill.dao.UserMapper;
import com.tearsmart.seckill.domain.User;
import com.tearsmart.seckill.service.IRedisService;
import com.tearsmart.seckill.vo.LoginVo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SeckillApplication.class)
public class SeckillApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IRedisService iRedisService;
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired

    @Test
    public void miaoTest() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // wrapper.eq("id", "1")
        //         .or().eq("name","liuyl").eq("id", "1");
        IPage page = new Page<>(1,2);
        if (page.ascs() == null && page.descs() == null ) {
            ((Page) page).setAsc("name");
        }
        IPage iPage = userMapper.selectPage(page, wrapper);
        System.out.println(iPage.getRecords().toString());
        userMapper.selectOne(wrapper);
    }

    @Test
    public void test() {
        User user = userMapper.selectOne(new QueryWrapper<>());
        System.out.println(user);
    }

    @Test
    public void redisTest() {
        // iRedisService.get();
    }

    @Before
    public void setUp() throws Exception {
        //       mvc = MockMvcBuilders.standaloneSetup(new TestController()).build();
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();//建议使用这种
    }

    @Test
    public void validTest() {
        LoginVo loginVo = new LoginVo();
        loginVo.setMobile("15038344602");
        loginVo.setPwd("111111111111111111111111");
        MvcResult success = null;
        try {
            success = mockMvc.perform(MockMvcRequestBuilders.get("/login/do_login")
                    .param("pwd", "111111111111111111111111")
                    .param("mobile", "15038344602")
                    .content(JSONObject.toJSONString(loginVo))
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .accept(MediaType.APPLICATION_JSON))
                    .andDo(MockMvcResultHandlers.print()).andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(success.getAsyncResult());

    }
}
