package com.tearsmart.seckill.vo;

import com.tearsmart.seckill.domain.Goods;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.Objects;

/**
 * <p>
 * 秒杀商品列表vo
 * </p>
 * @author tear-smart
 * @date 2018-12-12
 */
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

    public Double getMiaoshaPrice() {
        return miaoshaPrice;
    }

    public void setMiaoshaPrice(Double miaoshaPrice) {
        this.miaoshaPrice = miaoshaPrice;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Date getStartDate() {
        return (Date) startDate.clone();
    }

    public void setStartDate(Date startDate) {
        this.startDate = (Date) startDate.clone();
    }

    public Date getEndDate() {
        return (Date) endDate.clone();
    }

    public void setEndDate(Date endDate) {
        this.endDate = (Date) endDate.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        GoodsVo goodsVo = (GoodsVo) o;
        return Objects.equals(miaoshaPrice, goodsVo.miaoshaPrice) &&
                Objects.equals(stockCount, goodsVo.stockCount) &&
                Objects.equals(startDate, goodsVo.startDate) &&
                Objects.equals(endDate, goodsVo.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), miaoshaPrice, stockCount, startDate, endDate);
    }
}
