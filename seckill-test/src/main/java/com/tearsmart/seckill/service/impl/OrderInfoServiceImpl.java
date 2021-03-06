package com.tearsmart.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tearsmart.seckill.dao.OrderInfoMapper;
import com.tearsmart.seckill.domain.OrderInfo;
import com.tearsmart.seckill.service.IOrderInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 * @author tear-smart
 * @since 2018-12-05
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements IOrderInfoService {

}
