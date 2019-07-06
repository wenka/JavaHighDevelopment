package com.wenka.reflect.test;

import java.lang.annotation.*;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/06/11  下午 05:17
 * Description:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Index {

    int value();

}
