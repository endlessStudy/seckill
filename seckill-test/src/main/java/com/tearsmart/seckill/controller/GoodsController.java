package com.tearsmart.seckill.controller;


import com.alibaba.druid.util.StringUtils;
import com.tearsmart.seckill.constant.Constant;
import com.tearsmart.seckill.domain.Goods;
import com.tearsmart.seckill.domain.MiaoshaUser;
import com.tearsmart.seckill.redis.MiaoshaUserKey;
import com.tearsmart.seckill.result.Result;
import com.tearsmart.seckill.service.IGoodsService;
import com.tearsmart.seckill.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 * @author tear-smart
 * @since 2018-12-05
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    IGoodsService iGoodsService;
    @Autowired
    IRedisService redisService;
    @RequestMapping("/goodsList")
    public String getGoodsList(HttpServletResponse response,Model model,
                               @CookieValue(value = Constant.USER_COOKIE_NAME,required = false) String cookieToken,
                               @RequestParam(value = Constant.USER_COOKIE_NAME,required = false) String paramToken ) {
        if (StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)) {
            return "/";
        }
        String token = StringUtils.isEmpty(cookieToken) ? paramToken : cookieToken;
        MiaoshaUser user = iGoodsService.getMiaoshaUserFromRedis(response,token);
        model.addAttribute("user", user);
        // List<Goods> list = iGoodsService.list(null);
        return "hello";
    }
}
