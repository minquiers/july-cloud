package com.july.cloud.redis.lock;

import com.july.cloud.core.exception.redis.UnGetLockException;
import com.july.cloud.core.function.CheckedSupplier;
import com.july.cloud.core.utils.Exceptions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

/**
 * 锁客户端
 */
@Slf4j
@RequiredArgsConstructor
public class RedisLockClientImpl implements RedisLockClient {
    private final RedissonClient redissonClient;

    @Override
    public boolean tryLock(String lockName, LockType lockType, long waitTime, long leaseTime, TimeUnit timeUnit) throws InterruptedException {
        RLock lock = getLock(lockName, lockType);
        return lock.tryLock(waitTime, leaseTime, timeUnit);
    }

    @Override
    public void unLock(String lockName, LockType lockType) {
        RLock lock = getLock(lockName, lockType);
        // 仅仅在已经锁定和当前线程持有锁时解锁
        if (lock.isLocked() && lock.isHeldByCurrentThread()) {
            lock.unlock();
        }
    }

    private RLock getLock(String lockName, LockType lockType) {
        RLock lock;
        if (LockType.REENTRANT == lockType) {
            lock = redissonClient.getLock(lockName);
        } else {
            lock = redissonClient.getFairLock(lockName);
        }
        return lock;
    }

    @Override
    public <T> T lock(String lockName, LockType lockType, long waitTime, long leaseTime, TimeUnit timeUnit, CheckedSupplier<T> supplier) {
        try {
            boolean result = this.tryLock(lockName, lockType, waitTime, leaseTime, timeUnit);
            if (result) {
                return supplier.get();
            }
        } catch (Throwable e) {
            throw Exceptions.unchecked(e);
        } finally {
            this.unLock(lockName, lockType);
        }
        throw new UnGetLockException("un get redis lock");
    }

}
