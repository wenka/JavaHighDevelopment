package com.wenka.factory2;

/**
 * Created by 文卡 on 2017/1/9.
 */
public class TestMain {
    public static void main(String[] args) {
      /*  IHost host = new Host();
        ILCD lcd = new LCD();
        Computer computer = new Computer(host, lcd);
        computer.show();*/

        IFactory factory = new Factory();
        IComputer computer = factory.getComputer();
        computer.show();
    }
}
