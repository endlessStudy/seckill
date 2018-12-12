package com.tearsmart.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tearsmart.seckill.domain.MiaoshaGoods;
import com.tearsmart.seckill.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 * @author tear-smart
 * @since 2018-12-05
 */
public interface IMiaoshaGoodsService extends IService<MiaoshaGoods> {
    /**
     * 获取秒杀商品描述列表
     * @return
     */
    List<GoodsVo> getMiaoshaGoodsDesList();
}
