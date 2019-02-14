package com.tearsmart.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tearsmart.seckill.dao.MiaoshaOrderMapper;
import com.tearsmart.seckill.domain.MiaoshaOrder;
import com.tearsmart.seckill.domain.OrderInfo;
import com.tearsmart.seckill.service.IGoodsService;
import com.tearsmart.seckill.service.IMiaoshaGoodsService;
import com.tearsmart.seckill.service.IMiaoshaOrderService;
import com.tearsmart.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务实现类
 * </p>
 * @author tear-smart
 * @since 2018-12-05
 */
@Service
public class MiaoshaOrderServiceImpl extends ServiceImpl<MiaoshaOrderMapper, MiaoshaOrder> implements IMiaoshaOrderService {
    @Autowired
    IMiaoshaGoodsService miaoshaGoodsService;
    @Autowired
    IGoodsService goodsService;
    @Autowired
    MiaoshaOrderMapper miaoshaOrderMapper;

    /**
     * 根据商品Id查询商品详细信息
     * @param goodsId
     * @return
     */
    @Override
    public GoodsVo getMiaoshaGoodsDetailById(long goodsId) {
        return miaoshaGoodsService.getMiaoshaGoodsDetailById(goodsId);
    }

    /**
     * 修改商品库存 ,添加秒杀订单
     * @param goodsId
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderInfo addSeckillOrder(long goodsId, long userId) {
        //根据商品Id减少对应商品库存
        boolean stock = goodsService.reduceStock(goodsId);
        if (stock) {

        }
        //添加秒杀订单
        MiaoshaOrder order = new MiaoshaOrder();
        order.setGoodsId(goodsId);
        order.setUserId(userId);
        int insert = miaoshaOrderMapper.insert(order);
        if (insert > 0) {

        }
    return null;

    }
}
