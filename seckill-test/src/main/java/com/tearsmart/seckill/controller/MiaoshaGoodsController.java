package com.tearsmart.seckill.controller;


import com.tearsmart.seckill.domain.MiaoshaUser;
import com.tearsmart.seckill.service.IMiaoshaGoodsService;
import com.tearsmart.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/seckill-goods")
public class MiaoshaGoodsController {
    @Autowired
    IMiaoshaGoodsService miaoshaGoodsService;
    @RequestMapping("/goodsList")
    public String getGoodsList(HttpServletResponse response, Model model,
                               MiaoshaUser user) {
        model.addAttribute("user", user);
        List<GoodsVo> miaoshaGoodsDesList = miaoshaGoodsService.getMiaoshaGoodsDesList();
        model.addAttribute("miaoshaGoodsList", miaoshaGoodsDesList);
        return "goods_list";
    }
    @RequestMapping("/seckillGoods_detail/{goodsId}")
    public String getSeckillGoodsDetail(HttpServletResponse response, Model model,
                                        MiaoshaUser user, @PathVariable("goodsId") long goodsId) {
        model.addAttribute("user", user);
        GoodsVo detail = miaoshaGoodsService.getMiaoshaGoodsDetailById(goodsId);
        long startTime = detail.getStartDate().getTime();
        long endTime = detail.getEndDate().getTime();
        long currentTime = System.currentTimeMillis();
        int seckillStatus = 0;
        int remainSecond = 0;
        if (currentTime < startTime) {
            //秒杀还未开始
        seckillStatus = 0;
        remainSecond = (int) ((startTime - currentTime) / 1000);
        } else if (currentTime > endTime) {
            //秒杀已结束
            seckillStatus = 1;
        } else {
            //秒杀 进行中
            seckillStatus = 2;
        }
        model.addAttribute("seckillGoodsDetail", detail);
        model.addAttribute("remainSecond", remainSecond);
        model.addAttribute("seckillStatus", seckillStatus);
        return "goods_detail";
    }

}
