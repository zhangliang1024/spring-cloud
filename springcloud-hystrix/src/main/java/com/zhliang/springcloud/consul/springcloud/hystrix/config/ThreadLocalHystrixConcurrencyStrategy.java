package com.zhliang.springcloud.consul.springcloud.hystrix.config;

import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.properties.HystrixProperty;
import com.netflix.hystrix.util.PlatformSpecific;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @类描述：解决Hystrix使用线程池隔离时，ThreadLocal丢失数据问题
 * @创建人：zhiang
 * @创建时间：2020/9/1 15:23
 * @version：V1.0
 */
public class ThreadLocalHystrixConcurrencyStrategy extends HystrixConcurrencyStrategy {

    private final static Logger logger = LoggerFactory.getLogger(ThreadLocalHystrixConcurrencyStrategy.class);

    @Override
    public ThreadPoolExecutor getThreadPool(HystrixThreadPoolKey threadPoolKey, HystrixProperty<Integer> corePoolSize,
                                            HystrixProperty<Integer> maximumPoolSize, HystrixProperty<Integer> keepAliveTime, TimeUnit unit,
                                            BlockingQueue<Runnable> workQueue) {
        return this.doGetThreadPool(threadPoolKey, corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    private ThreadPoolExecutor doGetThreadPool(HystrixThreadPoolKey threadPoolKey, HystrixProperty<Integer> corePoolSize, HystrixProperty<Integer> maximumPoolSize, HystrixProperty<Integer> keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        ThreadFactory threadFactory = getThreadFactory(threadPoolKey);
        int dynamicCoreSize = (Integer)corePoolSize.get();
        int dynamicMaximumSize = (Integer)maximumPoolSize.get();
        if (dynamicCoreSize > dynamicMaximumSize) {
            logger.error("Hystrix ThreadPool configuration at startup for : " + threadPoolKey.name() + " is trying to set coreSize = " + dynamicCoreSize + " and maximumSize = " + dynamicMaximumSize + ".  Maximum size will be set to " + dynamicCoreSize + ", the coreSize value, since it must be equal to or greater than the coreSize value");
            return new ThreadLocalThreadPoolExecutor(dynamicCoreSize, dynamicCoreSize, (long)(Integer)keepAliveTime.get(), unit, workQueue, threadFactory);
        } else {
            return new ThreadLocalThreadPoolExecutor(dynamicCoreSize, dynamicMaximumSize, (long)(Integer)keepAliveTime.get(), unit, workQueue, threadFactory);
        }
    }

    @Override
    public ThreadPoolExecutor getThreadPool(HystrixThreadPoolKey threadPoolKey, HystrixThreadPoolProperties threadPoolProperties) {
        return this.doGetThreadPool(threadPoolKey, threadPoolProperties);
    }

    private ThreadPoolExecutor doGetThreadPool(HystrixThreadPoolKey threadPoolKey, HystrixThreadPoolProperties threadPoolProperties) {
        ThreadFactory threadFactory = getThreadFactory(threadPoolKey);
        boolean allowMaximumSizeToDivergeFromCoreSize = (Boolean)threadPoolProperties.getAllowMaximumSizeToDivergeFromCoreSize().get();
        int dynamicCoreSize = (Integer)threadPoolProperties.coreSize().get();
        int keepAliveTime = (Integer)threadPoolProperties.keepAliveTimeMinutes().get();
        int maxQueueSize = (Integer)threadPoolProperties.maxQueueSize().get();
        BlockingQueue<Runnable> workQueue = this.getBlockingQueue(maxQueueSize);
        if (allowMaximumSizeToDivergeFromCoreSize) {
            int dynamicMaximumSize = (Integer)threadPoolProperties.maximumSize().get();
            if (dynamicCoreSize > dynamicMaximumSize) {
                logger.error("Hystrix ThreadPool configuration at startup for : " + threadPoolKey.name() + " is trying to set coreSize = " + dynamicCoreSize + " and maximumSize = " + dynamicMaximumSize + ".  Maximum size will be set to " + dynamicCoreSize + ", the coreSize value, since it must be equal to or greater than the coreSize value");
                return new ThreadLocalThreadPoolExecutor(dynamicCoreSize, dynamicCoreSize, (long)keepAliveTime, TimeUnit.MINUTES, workQueue, threadFactory);
            } else {
                return new ThreadLocalThreadPoolExecutor(dynamicCoreSize, dynamicMaximumSize, (long)keepAliveTime, TimeUnit.MINUTES, workQueue, threadFactory);
            }
        } else {
            return new ThreadLocalThreadPoolExecutor(dynamicCoreSize, dynamicCoreSize, (long)keepAliveTime, TimeUnit.MINUTES, workQueue, threadFactory);
        }
    }

    private static ThreadFactory getThreadFactory(final HystrixThreadPoolKey threadPoolKey) {
        return !PlatformSpecific.isAppEngineStandardEnvironment() ? new ThreadFactory() {
            private final AtomicInteger threadNumber = new AtomicInteger(0);
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r, "hystrix-" + threadPoolKey.name() + "-" + this.threadNumber.incrementAndGet());
                thread.setDaemon(true);
                return thread;
            }
        } : PlatformSpecific.getAppEngineThreadFactory();
    }

}
