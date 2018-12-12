package com.tearsmart.seckill.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tearsmart.seckill.dao.GoodsMapper;
import com.tearsmart.seckill.domain.Goods;
import com.tearsmart.seckill.domain.MiaoshaUser;
import com.tearsmart.seckill.service.IGoodsService;
import com.tearsmart.seckill.service.IMiaoshaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 服务实现类
 * </p>
 * @author tear-smart
 * @since 2018-12-05
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {
    @Autowired
    IMiaoshaUserService miaoshaUserService;

    /**
     * 从redis中获取秒杀用户
     * @param token
     * @return 秒杀用户
     */
    @Override
    public MiaoshaUser getMiaoshaUserFromRedis(HttpServletResponse response,String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        MiaoshaUser miaoshaUser = miaoshaUserService.getUserFromRedis(response,token);
        return miaoshaUser;
    }
}
