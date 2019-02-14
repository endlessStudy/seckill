package com.tearsmart.seckill.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tearsmart.seckill.domain.OrderInfo;
import com.tearsmart.seckill.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * Mapper 接口
 * </p>
 * @author tear-smart
 * @since 2018-12-05
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     *
     * @param user
     * @return
     */
    User queryUser(@Param("info") OrderInfo info, @Param("user") User user);
}
