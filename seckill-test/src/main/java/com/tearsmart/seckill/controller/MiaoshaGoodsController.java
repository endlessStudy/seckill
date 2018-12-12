package com.tearsmart.seckill.controller;


import com.tearsmart.seckill.domain.MiaoshaUser;
import com.tearsmart.seckill.service.IMiaoshaGoodsService;
import com.tearsmart.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/miaosha-goods")
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

}
