package com.wenka.filecopy.thread;

import com.wenka.filecopy.log.LogUtil;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IDEA
 *
 * @author wenka wkwenka@gmail.com
 * @date 2020/09/12  上午 11:41
 * @description:
 */
public class ThreadPoorService {

    private static final int maximumPoolSize = Runtime.getRuntime().availableProcessors() * 2;
    private static final int corePoolSize = maximumPoolSize / 2;
    private static final long keepAliveTime = 60L;
    private static final TimeUnit timeUnit = TimeUnit.SECONDS;

    private static final int MAX_QUEUE = 10000;
    private static final BlockingQueue queue = new LinkedBlockingQueue(MAX_QUEUE);

    private static final ThreadPoolExecutor threadPoolExecutor;

    static {
        LogUtil.info("核心线程数：" + corePoolSize);
        LogUtil.info("最大线程数：" + maximumPoolSize);
        threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, timeUnit, queue, new MyThreadFactory(), new MyRejectedExecutionHandler());
    }


    public static void run(Runnable runnable) {
        threadPoolExecutor.execute(runnable);
    }

    public static int getActiveCount(){
        return threadPoolExecutor.getActiveCount();
    }
}
