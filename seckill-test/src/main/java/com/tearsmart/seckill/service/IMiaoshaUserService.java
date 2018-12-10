package com.tearsmart.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tearsmart.seckill.domain.MiaoshaUser;
import com.tearsmart.seckill.vo.LoginVo;

/**
 * <p>
 * 服务类
 * </p>
 * @author tear-smart
 * @since 2018-12-05
 */
public interface IMiaoshaUserService extends IService<MiaoshaUser> {
    /**
     * 登录查询验证
     * @param loginVo 登录vo
     * @return codeMessage
     */
    boolean login(LoginVo loginVo);
}
