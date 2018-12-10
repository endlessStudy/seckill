package com.tearsmart.seckill.controller;

import com.tearsmart.seckill.result.CodeMessage;
import com.tearsmart.seckill.result.Result;
import com.tearsmart.seckill.service.IMiaoshaUserService;
import com.tearsmart.seckill.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.io.IOException;

/**
 * <p>
 *  登录控制controller
 * </p>
 * @author tear-smart
 * @date 2018-12-09
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private IMiaoshaUserService miaoshaUserService;

    @RequestMapping("/do_login")
    @ResponseBody
    public Result doLogin(@Valid LoginVo loginVo) throws IOException {
        miaoshaUserService.login(loginVo);
        return Result.success(true);
    }
}
