package com.tearsmart.seckill.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tearsmart.seckill.domain.Goods;
import com.tearsmart.seckill.result.Result;
import com.tearsmart.seckill.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 * @author tear-smart
 * @since 2018-12-05
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    IGoodsService iGoodsService;

    @RequestMapping("/goodsList")
    @ResponseBody
    public Result getGoodsList() {
        List<Goods> list = iGoodsService.list(null);
        return Result.success(list);
    }

    @RequestMapping("/goodsOne")
    @ResponseBody
    public Result getGoodsOne() {
        Goods goods = iGoodsService.getOne(new QueryWrapper<Goods>());
        return Result.success(goods);
    }

}
