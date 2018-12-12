package com.tearsmart.seckill.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tearsmart.seckill.domain.MiaoshaGoods;
import com.tearsmart.seckill.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 * @author tear-smart
 * @since 2018-12-05
 */
@Mapper
public interface MiaoshaGoodsMapper extends BaseMapper<MiaoshaGoods> {
    /**
     * 查询秒杀商品列表,以及对应商品表中的相关信息
     * @return
     */
    @Select("select g.*,mg.stock_count, mg.start_date, mg.end_date,mg.miaosha_price from miaosha_goods mg left join goods g on mg.goods_id = g.id")
    List<GoodsVo> getMiaoshaGoodsDesList();
}
