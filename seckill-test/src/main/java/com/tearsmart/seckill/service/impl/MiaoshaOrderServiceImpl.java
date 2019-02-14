package com.tearsmart.seckill.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tearsmart.seckill.dao.MiaoshaOrderMapper;
import com.tearsmart.seckill.domain.MiaoshaGoods;
import com.tearsmart.seckill.domain.MiaoshaOrder;
import com.tearsmart.seckill.service.IMiaoshaGoodsService;
import com.tearsmart.seckill.service.IMiaoshaOrderService;
import com.tearsmart.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

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
    @Transactional
    public void addSeckillOrder(long goodsId) {
        MiaoshaOrder miaoshaOrder = null;
        // miaoshaOrder.getGoodsId();
        miaoshaOrder = new MiaoshaOrder();
        //1547	18912341234	1561	1
        miaoshaOrder.setGoodsId(1L);
        miaoshaOrder.setUserId(18922341234L);
        miaoshaOrder.setOrderId(15L);
        miaoshaOrderMapper.insert(miaoshaOrder);
        try {
            miaoshaGoodsService.test(goodsId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
