package com.wenka.filecopy;

import com.wenka.filecopy.config.SysConfig;
import com.wenka.filecopy.log.LogUtil;
import com.wenka.filecopy.service.ErrorCopyService;
import com.wenka.filecopy.service.FileCopyService;
import com.wenka.filecopy.thread.ThreadPoorService;

import java.io.File;
import java.util.Arrays;

/**
 * Created with IDEA
 *
 * @author wenka wkwenka@gmail.com
 * @date 2020/09/12  上午 11:39
 * @description:
 */
public class FileCopyMain {

    public static void main(String[] args) {
        String filePath = System.getProperty("filePath");
        String targetPath = System.getProperty("targetPath");
        String areaCount = System.getProperty("areaCount", "1000");
        LogUtil.info("服务启动...");
        LogUtil.info("CPU核心数：" + Runtime.getRuntime().availableProcessors());
        LogUtil.info("读取跟文件夹：" + filePath);
        LogUtil.info("目标跟文件夹：" + targetPath);
        LogUtil.info("目标文件夹最大数：" + areaCount);
        SysConfig.setTargetRootPath(targetPath);
        SysConfig.setAreaCount(Integer.valueOf(areaCount));
        File file = new File(filePath);

        Thread thread = new Thread(new ErrorCopyService());
        thread.setName("error-log");
        thread.start();

        fileCopy(file);
        LogUtil.info("文件扫描完毕");

        //主线程负责监测
        while (true) {
            LogUtil.info("监测：当前活动线程数【" + ThreadPoorService.getActiveCount() + "]");
            if (ThreadPoorService.getActiveCount() == 0) {
                //等待错误日志线程结束
                SysConfig.SYS_RUN.set(false);
                while (thread.getState() != Thread.State.TERMINATED) {
                    LogUtil.info("等待错误记录线程结束...");
                }
                LogUtil.info("程序结束！！！！！");
                System.exit(0);
            }
            try {
                System.out.println(thread.getState());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void fileCopy(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            Arrays.stream(files).forEach(f -> {
                if (f.isDirectory()) {
                    fileCopy(f);
                } else if (f.getName().endsWith(".tar")) {
                    LogUtil.info("》》》》》》》 Tar包不解析 《《《《《《《《");
                } else {
                    while (!SysConfig.WAITING.get()) {
                        ThreadPoorService.run(new FileCopyService(f));
                        break;
                    }
                }
            });
        }
    }
}
