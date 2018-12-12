package com.tearsmart.seckill.vo;

import com.tearsmart.seckill.domain.Goods;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.AssertTrue;
import java.util.Date;

/**
 * <p>
 * 秒杀商品列表vo
 * </p>
 * @author tear-smart
 * @date 2018-12-12
 */
@Data
@Accessors(chain = true)
public class GoodsVo extends Goods{
    /**
     * 秒杀价格
     */
    private Double miaoshaPrice;
    /**
     * 库存
     */
    private Integer stockCount;
    /**
     * 秒杀开始时间
     */
    private Date startDate;
    /**
     * 秒杀结束时间
     */
    private Date endDate;


}
