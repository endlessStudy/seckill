package com.tearsmart.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tearsmart.seckill.domain.MiaoshaOrder;
import com.tearsmart.seckill.domain.OrderInfo;
import com.tearsmart.seckill.vo.GoodsVo;

/**
 * <p>
 * 服务类
 * </p>
 * @author tear-smart
 * @since 2018-12-05
 */
public interface IMiaoshaOrderService extends IService<MiaoshaOrder> {

    /**
     * 根据商品Id查询商品详细信息
     * @param goodsId
     * @return
     */
    GoodsVo getMiaoshaGoodsDetailById(long goodsId);

    /**
     * 修改商品库存 ,添加秒杀订单
     * @param goodsId
     * @return
     */

    OrderInfo addSeckillOrder(long goodsId, long userId);
}
