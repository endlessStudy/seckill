package com.tearsmart.seckill.redis;

/**
 * <p>
 *
 * </p>
 * @author tear-smart
 * @date 2018-12-11
 */
public interface BaseRedisKey {
    /**
     * 得到过期时间,单位为秒
     * @return 过期时间
     */
    int expireSeconds();

    /**
     * 得到key的前缀
     * @return 前缀
     *
     */
    String getPrefix();
}
