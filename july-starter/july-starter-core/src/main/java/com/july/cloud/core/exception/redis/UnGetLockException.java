package com.july.cloud.core.exception.redis;

/**
 * 未获取到锁异常
 */
public class UnGetLockException extends RuntimeException {
    public UnGetLockException(String message) {
        super(message);
    }

    public UnGetLockException(Throwable cause) {
        super(cause);
    }

    public UnGetLockException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnGetLockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
