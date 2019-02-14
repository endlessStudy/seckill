package com.tearsmart.seckill.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tearsmart.seckill.domain.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * Mapper 接口
 * </p>
 * @author tear-smart
 * @since 2018-12-05
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
    /**
     * 根据商品id 减少库存
     * @param id
     * @return 更新条数
     */
    @Update("update goods set goods_stock = goods_stock -1 where id = #{goodsId} and goods_stock > 0")
    int reduceStock(long id);
}
