package com.wenka.thread;

public class Main2 {
	public static void main(String[] args) {
		new PrintA().start();
		new PrintB().start();
		new PrintC().start();
	}
}

class PrintA extends Thread {
	@Override
	public void run() {
		try {
			new PrintABC().printA();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class PrintB extends Thread {
	@Override
	public void run() {
		try {
			new PrintABC().printB();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class PrintC extends Thread {
	@Override
	public void run() {
		try {
			new PrintABC().printC();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class PrintABC {
	private static int flag = 1;// 条件变量
	private static Object object = new Object();// 对象锁

	public void printA() throws InterruptedException{
		for (int i = 0; i < 10; i++) {
			synchronized (object) {
				while (flag != 1) {
					object.wait();
				}
				System.out.println(Thread.currentThread().getName() + " ---> " + "A");
				flag = 2;
				object.notifyAll();
			}
			
		}
	}
	
	public void printB() throws InterruptedException{
		for (int i = 0; i < 10; i++) {
			synchronized (object) {
				while (flag != 2) {
					object.wait();
				}
				System.out.println(Thread.currentThread().getName() + " ---> " + "B");
				flag = 3;
				object.notifyAll();
			}
			
		}
	}
	
	public void printC() throws InterruptedException{
		for (int i = 0; i < 10; i++) {
			synchronized (object) {
				while (flag != 3) {
					object.wait();
				}
				System.out.println(Thread.currentThread().getName() + " ---> " + "C");
				flag = 1;
				object.notifyAll();
			}
			
		}
	}
}