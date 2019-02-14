package com.tearsmart.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tearsmart.seckill.domain.Goods;
import com.tearsmart.seckill.domain.MiaoshaUser;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 服务类
 * </p>
 * @author tear-smart
 * @since 2018-12-05
 */
public interface IGoodsService extends IService<Goods> {
    /**
     * 从redis中获取秒杀用户
     * @param response
     * @param token
     * @return 秒杀用户
     */
    MiaoshaUser getMiaoshaUserFromRedis(HttpServletResponse response, String token);

    /**
     * 根据商品id 减少库存
     * @param id
     * @return 更新条数
     */
    boolean reduceStock(long id);
}
