package com.tearsmart.seckill.controller;


import com.tearsmart.seckill.domain.MiaoshaUser;
import com.tearsmart.seckill.service.IMiaoshaUserService;
import com.tearsmart.seckill.util.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * <p>
 * 前端控制器
 * </p>
 * @author tear-smart
 * @since 2018-12-05
 */
@RestController
@RequestMapping("/miaosha-user")
public class MiaoshaUserController {
    @Autowired
    IMiaoshaUserService miaoshaUserService;

    @RequestMapping("/saveUser")
    @ResponseBody
    public void addUser(MiaoshaUser user) {
        String password = Md5Utils.testFun("123456");
        String salt = Md5Utils.randomSalt();
        System.out.println(password + " : " + salt);
        String pwd = Md5Utils.dbEncry(password, salt);
        user = new MiaoshaUser();
        user.setNickname("liuyl");
        user.setSalt(salt);
        user.setPassword(pwd);
        user.setPhoneNumber("15038344602");
        user.setRegisterDate(LocalDateTime.now());
        miaoshaUserService.save(user);
    }

}
