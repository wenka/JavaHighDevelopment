package com.wenka.filecopy.service;

import com.wenka.filecopy.config.SysConfig;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IDEA
 *
 * @author wenka wkwenka@gmail.com
 * @date 2020/09/12  下午 03:03
 * @description:
 */
public class ErrorCopyService implements Runnable {

    private String filePrefix = "log-";
    private String fileSuffix = ".txt";

    private String fileName;

    public static volatile BlockingQueue<String> queue = new LinkedBlockingQueue();

    public ErrorCopyService() {
        this.fileName = this.getFileName();
    }

    public void log() {
        File f = new File(fileName);
        try (
                FileOutputStream fos = new FileOutputStream(f);
        ) {
            while (!queue.isEmpty() || SysConfig.SYS_RUN.get()) {
                while (!queue.isEmpty()) {
                    String poll = queue.poll();
                    byte[] b = (poll + "\n").getBytes();
                    fos.write(b);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String getFileName() {
        return filePrefix + LocalDate.now().toString() + fileSuffix;
    }

    /**
     *
     */
    @Override
    public void run() {
        this.log();
    }
}
