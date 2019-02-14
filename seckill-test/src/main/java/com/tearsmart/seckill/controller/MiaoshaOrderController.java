package com.tearsmart.seckill.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tearsmart.seckill.domain.MiaoshaOrder;
import com.tearsmart.seckill.domain.MiaoshaUser;
import com.tearsmart.seckill.domain.OrderInfo;
import com.tearsmart.seckill.result.CodeMessage;
import com.tearsmart.seckill.service.IMiaoshaGoodsService;
import com.tearsmart.seckill.service.IMiaoshaOrderService;
import com.tearsmart.seckill.service.IOrderInfoService;
import com.tearsmart.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 前端控制器
 * </p>
 * @author tear-smart
 * @since 2018-12-05
 */
@Controller
@RequestMapping("/seckill-order")
public class MiaoshaOrderController {

    @Autowired
    IMiaoshaOrderService miaoshaOrderService;
    @RequestMapping("/do_seckill")
    public String test(Model model, @RequestParam(value = "goodsId")long goodsId, MiaoshaUser user) {
        if (user == null) {
            return "/";
        }
        GoodsVo detail = miaoshaOrderService.getMiaoshaGoodsDetailById(goodsId);
        int stock = detail.getStockCount();
        if (stock <= 0) {
            model.addAttribute("errorMsg", CodeMessage.STOCK_ZERO.getMessage());
            return "seckill_fail";
        }
        QueryWrapper<MiaoshaOrder> query = new QueryWrapper<>();
        query.eq("goods_id",goodsId).eq("user_id",user.getId());
        int count = miaoshaOrderService.count(query);
        if (count > 0) {
            model.addAttribute("errorMessage", CodeMessage.REPEAT_ERROR.getMessage());
            return "seckill_fail";
        }

        return "";
    }
    @RequestMapping("/{goodsId}")
    public void reduceStockAndCreateSeckillOrder(@PathVariable long goodsId,MiaoshaUser user){
        miaoshaOrderService.addSeckillOrder(goodsId,user.getId());
    }

}
