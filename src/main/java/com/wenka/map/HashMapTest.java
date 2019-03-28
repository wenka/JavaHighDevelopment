package com.wenka.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/03/28  上午 10:49
 * Description:
 */
public class HashMapTest {

    @Test
    public void test() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("username", "admin");
        map.put("password", "123");
        map.put("password", "123456");
        String password = map.get("password");
        System.out.println(password);

        Hashtable<Object, Object> objectObjectHashtable = new Hashtable<>();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
    }

    /**
     * Java中的hashCode方法就是根据一定的规则将与对象相关的信息
     * （比如对象的存储地址，对象的字段等）映射成一个数值，
     * 这个数值称作为散列值
     */
    @Test
    public void test2() {
        String key = "2";
        System.out.println(key.hashCode());
        System.out.println(key.hashCode() >>> 16);
//        -265713450 -265713450
    }

    @Test
    public void test3() {
        int a = 15; // 10
        System.out.println(a + " = " + Integer.toBinaryString(a));
        int b = a >> 3;
        System.out.println(b + " = " + Integer.toBinaryString(b));
        int c = a ^ b;
        System.out.println(c + " = " + Integer.toBinaryString(c));
    }
}
