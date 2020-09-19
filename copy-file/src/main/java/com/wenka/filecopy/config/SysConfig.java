package com.wenka.filecopy.config;

import java.util.Collections;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

/**
 * Created with IDEA
 *
 * @author wenka wkwenka@gmail.com
 * @date 2020/09/12  下午 02:52
 * @description:
 */
public class SysConfig {

    private static String targetRootPath;
    private static int areaCount;

    public static String getTargetRootPath() {
        return targetRootPath;
    }

    public static AtomicBoolean WAITING = new AtomicBoolean(false);
    public static AtomicBoolean SYS_RUN = new AtomicBoolean(true);

    public static void setTargetRootPath(String targetRootPath) {
        if (!targetRootPath.endsWith("\\")) {
            targetRootPath += "\\";
        }
        SysConfig.targetRootPath = targetRootPath;
    }

    public static int getAreaCount() {
        return areaCount;
    }

    public static void setAreaCount(int areaCount) {
        SysConfig.areaCount = areaCount;
    }
}
