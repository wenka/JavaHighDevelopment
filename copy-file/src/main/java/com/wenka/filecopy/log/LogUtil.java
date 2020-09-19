package com.wenka.filecopy.log;

import java.time.LocalDateTime;

/**
 * Created with IDEA
 *
 * @author wenka wkwenka@gmail.com
 * @date 2020/09/12  下午 02:44
 * @description:
 */
public class LogUtil {

    public static void info(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + "-----" + LocalDateTime.now() + "【INFO】 >>>>>>>>>>>  [ " + message + " ]");
    }

    public static void error(String message) {
        String threadName = Thread.currentThread().getName();
        System.err.println(threadName + "-----" + LocalDateTime.now() + "【ERROR】 >>>>>>>>>>>  [ " + message + " ]");
    }
}
