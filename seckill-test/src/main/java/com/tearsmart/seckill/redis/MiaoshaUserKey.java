package com.tearsmart.seckill.redis;

import com.tearsmart.seckill.constant.Constant;

/**
 * <p>
 *
 * </p>
 * @author tear-smart
 * @date 2018-12-11
 */
public class MiaoshaUserKey extends BasePrefix {
    private String prefix;

    public MiaoshaUserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
        this.prefix = prefix;
    }

    public static MiaoshaUserKey token = new MiaoshaUserKey(Constant.USER_COOKIE_EXPIRY, "tk");

	public static MiaoshaUserKey getById = new MiaoshaUserKey(0, "id");

	public MiaoshaUserKey withExpire(int seconds) {
		return new MiaoshaUserKey(seconds, prefix);
	}

}
