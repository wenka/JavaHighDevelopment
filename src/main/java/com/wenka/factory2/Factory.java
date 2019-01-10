package com.wenka.factory2;

/**
 * Created by 文卡 on 2017/1/9.
 */
public class Factory implements IFactory {
    
    @Override
    public IComputer getComputer() {
        IHost host = new Host();
        ILCD lcd = new LCD();
        IComputer computer = new Computer(host, lcd);
        return computer;
    }
    
}
