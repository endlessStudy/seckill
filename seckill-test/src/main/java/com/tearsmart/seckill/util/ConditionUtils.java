package com.tearsmart.seckill.util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tearsmart.seckill.domain.User;
import io.netty.util.internal.StringUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 *
 * </p>
 * @author tear-smart
 * @date 2019-01-02
 */
public class ConditionUtils {
    private QueryWrapper query ;

    public void joinConditions(User user){
        query = new QueryWrapper<User>();
        query.eq(StringUtils.isEmpty(user.getName()),"username",user.getName());
    }
}
