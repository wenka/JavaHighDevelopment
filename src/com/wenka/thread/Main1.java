package com.wenka.thread;

public class Main1 {
	public static void main(String[] args) {

		Thread1 thread1 = new Thread1();
		thread1.start();
		
		Target target = new Target();
		new Thread(target).start();
		
		for(int i = 0; i < 10; i++){
			System.out.println(i + "--->main");
		}
		
	}
}

class Thread1 extends Thread{
	@Override
	public void run() {
		for(int i = 0; i < 10; i++){
			System.out.println(i + " --->Thread");
		}
	}
}

class Target implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i < 10; i++){
			System.out.println(i + " --->target");
		}
	}
	
}