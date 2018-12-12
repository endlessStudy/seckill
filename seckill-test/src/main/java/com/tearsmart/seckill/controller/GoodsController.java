package com.tearsmart.seckill.controller;


import com.tearsmart.seckill.domain.MiaoshaUser;
import com.tearsmart.seckill.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

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

}
