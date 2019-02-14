package com.tearsmart.seckill.controller;


import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tearsmart.seckill.dao.UserMapper;
import com.tearsmart.seckill.domain.OrderInfo;
import com.tearsmart.seckill.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ┌─┐       ┌─┐
 * ┌──┘ ┴───────┘ ┴──┐
 * │       ───       │
 * │  ─┬┘       └┬─  │
 * │                 │
 * │       ─┴─       │
 * └───┐         ┌───┘
 * ----│         │
 * ----│         └──────────────┐
 * ----│                        ├─┐
 * ----│                        ┌─┘
 * ----└─┐  ┐  ┌───────┬──┐  ┌──┘
 * ----  │ ─┤ ─┤       │ ─┤ ─┤
 * ----  └──┴──┘       └──┴──┘
 * 神兽保佑
 * 代码无BUG!
 * <p>
 * 前端控制器
 * </p>
 * @author tear-smart
 * @since 2018-12-05
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/test")
    @ResponseBody
    public Object test() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", "1")
                .or(q -> q.eq("name", "liuyl").eq("id", "1"));

        return userMapper.selectOne(wrapper);
    }
}
