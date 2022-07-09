package com.july.cloud.redis.lock;

/**
 * 锁类型
 *
 */
public enum LockType {
	/**
	 * 重入锁
	 */
	REENTRANT,
	/**
	 * 公平锁
	 */
	FAIR
}
