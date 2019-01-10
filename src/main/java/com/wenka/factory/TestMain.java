package com.wenka.factory;

/**
 * Created by 文卡 on 2017/1/9.
 */
public class TestMain {
    public static void main(String[] args){
        IFactory factory = new Factory();
        IProduct product = factory.createProduct();
        product.productMethod();

    }
}
