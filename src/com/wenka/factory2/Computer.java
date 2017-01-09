package com.wenka.factory2;

/**
 * Created by 文卡 on 2017/1/9.
 */
public class Computer implements IComputer{

    private IHost host;
    private ILCD lcd;

    public Computer(IHost host, ILCD lcd){
        this.host = host;
        this.lcd = lcd;
    }

    @Override
    public void show(){
        host.show();
        lcd.show();
    }

}
