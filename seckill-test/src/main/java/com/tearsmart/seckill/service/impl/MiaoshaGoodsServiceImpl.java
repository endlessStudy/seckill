package com.tearsmart.seckill.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tearsmart.seckill.dao.MiaoshaGoodsMapper;
import com.tearsmart.seckill.domain.Goods;
import com.tearsmart.seckill.domain.MiaoshaGoods;
import com.tearsmart.seckill.service.IGoodsService;
import com.tearsmart.seckill.service.IMiaoshaGoodsService;
import com.tearsmart.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 * @author tear-smart
 * @since 2018-12-05
 */
@Service
public class MiaoshaGoodsServiceImpl extends ServiceImpl<MiaoshaGoodsMapper, MiaoshaGoods> implements IMiaoshaGoodsService {
    @Autowired
    MiaoshaGoodsMapper miaoshaGoodsMapper;

    /**
     * 获取秒杀商品描述列表
     * @return
     */
    @Override
    public List<GoodsVo> getMiaoshaGoodsDesList() {
        return miaoshaGoodsMapper.getMiaoshaGoodsDesList();
    }
}
