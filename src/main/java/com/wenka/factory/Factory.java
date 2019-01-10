package com.wenka.factory;

/**
 * Created by Administrator on 2017/1/9.
 */
public class Factory implements IFactory {
    @Override
    public IProduct createProduct() {
        return  new Product();
    }
}
