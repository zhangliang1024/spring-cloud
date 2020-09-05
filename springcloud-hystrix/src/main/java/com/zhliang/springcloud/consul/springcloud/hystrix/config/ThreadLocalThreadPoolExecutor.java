package com.zhliang.springcloud.consul.springcloud.hystrix.config;

import com.alibaba.ttl.TtlRunnable;

import java.util.concurrent.*;

/**
 * @类描述：解决Hystrix使用线程池隔离时，ThreadLocal丢失数据问题
 * @创建人：zhiang
 * @创建时间：2020/9/1 15:25
 * @version：V1.0
 */
public class ThreadLocalThreadPoolExecutor extends ThreadPoolExecutor {

    private static final RejectedExecutionHandler defaultHandler = new AbortPolicy();

    public ThreadLocalThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public ThreadLocalThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, defaultHandler);
    }

    @Override
    public void execute(Runnable command) {
        //使用阿里开源 transmittable-thread-local解决线程复用情况下的值传递
        super.execute(TtlRunnable.get(command));
    }
}
