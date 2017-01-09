package com.wenka.factory2;

/**
 * Created by 文卡 on 2017/1/9.
 */
public class LCD implements ILCD {
    @Override
    public void show() {
        System.out.println("This is Computer's LCD...");
    }
}
