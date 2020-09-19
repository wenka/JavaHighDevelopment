package com.wenka.filecopy.thread;

import com.wenka.filecopy.config.SysConfig;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created with IDEA
 *
 * @author wenka wkwenka@gmail.com
 * @date 2020/09/12  下午 12:00
 * @description:
 */
public class MyRejectedExecutionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(">>>>>>>>>>>>>>>>>>>> 线程队列已经满员 <<<<<<<<<<<<<<<<<<<<");
        SysConfig.WAITING.set(true);
        executor.execute(r);
    }
}
