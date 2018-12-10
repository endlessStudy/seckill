package com.tearsmart.seckill.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tearsmart.seckill.dao.MiaoshaUserMapper;
import com.tearsmart.seckill.domain.MiaoshaUser;
import com.tearsmart.seckill.exception.GlobalException;
import com.tearsmart.seckill.result.CodeMessage;
import com.tearsmart.seckill.service.IMiaoshaUserService;
import com.tearsmart.seckill.util.Md5Utils;
import com.tearsmart.seckill.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 * @author tear-smart
 * @since 2018-12-05
 */
@Service
public class MiaoshaUserServiceImpl extends ServiceImpl<MiaoshaUserMapper, MiaoshaUser> implements IMiaoshaUserService {
    @Autowired
    private MiaoshaUserMapper miaoshaUserMapper;

    /**
     * 用户登录验证
     * @param loginVo 登录vo
     * @return codeMessage
     */
    @Override
    public boolean login(LoginVo loginVo) {
        if (loginVo == null) {
            throw new GlobalException(CodeMessage.SERVER_ERROR);
        }
        QueryWrapper<MiaoshaUser> query = new QueryWrapper<MiaoshaUser>();
        query.eq("phone_number", loginVo.getMobile());
        MiaoshaUser user = miaoshaUserMapper.selectOne(query);
        //用户验证
        if (user == null) {
            throw new GlobalException(CodeMessage.USER_NOT_EXIST);
        }
        //密码验证
        if (!StringUtils.equals(user.getPassword(), Md5Utils.dbEncry(loginVo.getPwd(), user.getSalt()))) {
            throw new GlobalException(CodeMessage.PASSWORD_ERROR);
        }
        return true;
    }
}
