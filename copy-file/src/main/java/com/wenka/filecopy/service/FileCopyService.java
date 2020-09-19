package com.wenka.filecopy.service;

import com.wenka.filecopy.config.SysConfig;
import com.wenka.filecopy.log.LogUtil;
import com.wenka.filecopy.thread.ThreadPoorService;

import java.io.*;
import java.util.Arrays;

/**
 * Created with IDEA
 *
 * @author wenka wkwenka@gmail.com
 * @date 2020/09/12  下午 02:35
 * @description:
 */
public class FileCopyService implements Runnable {

    private File file;

    private File targetFile;

    public FileCopyService(File file) {
        this.file = file;
    }

    private boolean isFile() {
        return this.file.isFile();
    }

    /**
     * 计算文件目标拷贝位置
     */
    private void calcTargetPath() {
        String name = this.file.getName();
//        LogUtil.info("文件名：" + this.file.getAbsolutePath());
        int hash = hash(name);
        String target = SysConfig.getTargetRootPath() + Math.abs(hash) % SysConfig.getAreaCount();
//        LogUtil.info("目标目录：" + target);
        this.targetFile = new File(target);
        if (!this.targetFile.exists()) {
            try {
                this.targetFile.mkdirs();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.targetFile = new File(this.targetFile.getAbsolutePath() + "/" + this.file.getName());
    }

    private int hash(String name) {
        int h;
        return (name == null) ? 0 : (h = name.hashCode()) ^ (h >>> 16);
    }

    /**
     * 复制文件
     *
     * @return
     */
    private boolean copyFile() {
        if (this.targetFile.exists()){
            return true;
        }
        boolean flag = false;
        try (
                InputStream inputStream = new FileInputStream(file);
                OutputStream outputStream = new FileOutputStream(this.targetFile);
        ) {
            byte[] buffer = new byte[1024];
            int len = 0;

            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
            flag = true;
        } catch (FileNotFoundException e) {
            LogUtil.error(e.getMessage());
            flag = false;
        } catch (IOException e) {
            LogUtil.error(e.getMessage());
            flag = false;
        }
        return flag;
    }

    @Override
    public void run() {
        if (!this.isFile()) {
            LogUtil.info(this.file.getAbsolutePath() + "为文件夹，不进行拷贝！");
            return;
        }
        // 计算目标位置
        this.calcTargetPath();
        // 进行拷贝
        if (this.copyFile()) {
            LogUtil.info(this.file.getAbsolutePath() + " 拷贝成功至 " + this.targetFile.getAbsolutePath());
        } else {
            LogUtil.error(this.file.getAbsolutePath() + " 拷贝失败！！");
            // 记录拷贝出错文件
            try {
                ErrorCopyService.queue.put(this.file.getAbsolutePath());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        SysConfig.WAITING.set(false);
    }
}
