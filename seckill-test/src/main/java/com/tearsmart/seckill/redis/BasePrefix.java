package com.tearsmart.seckill.redis;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 * @author tear-smart
 * @date 2018-12-11
 */
public class BasePrefix implements BaseRedisKey {
    private int expireSeconds;

	private String prefix;

	public static final Integer NO_EXPIRE = 0;
	public BasePrefix(String prefix) {//0代表永不过期
		this(0, prefix);
	}

	public BasePrefix( int expireSeconds, String prefix) {
		this.expireSeconds = expireSeconds;
		this.prefix = prefix;
	}

	@Override
	public int expireSeconds() {//默认0代表永不过期
		return expireSeconds;
	}

	@Override
	public String getPrefix() {
		String className = getClass().getSimpleName();
		return className+":" + prefix;
	}
}
