package com.wenka.factory;

/**
 * Created by 文卡 on 2017/1/9.
 */
public class Product implements IProduct {

    @Override
    public void productMethod() {
        System.out.println("This is Product Method...");
    }
}
