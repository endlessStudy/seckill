package com.tearsmart.seckill.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tearsmart.seckill.dao.GoodsMapper;
import com.tearsmart.seckill.domain.Goods;
import com.tearsmart.seckill.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    GoodsMapper goodsMapper;


}
