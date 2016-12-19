package com.wenka.thread;

import java.util.LinkedList;
import java.util.Queue;

public class Main3 {
	public static void main(String[] args) {
		Producter producter = new Producter();
		Consumer consumer = new Consumer();
		
		producter.setName("Products----->");
		consumer.setName("Consumer----->");
		
		producter.start();
		consumer.start();
	}
}

class Products{
	static int maxSize = 10;
	static Queue<Integer> products = new LinkedList<Integer>(); //产品队列
}

//生产者
class Producter extends Thread{
	
	@Override
	public void run() {
		int i = 0;
		while (true) {
			synchronized (Products.class) {
				
				while (Products.products.size() == Products.maxSize) {
					System.out.println("仓库已经满了");
					try {
						Products.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "生产出来的产品编号：" + i);
				Products.products.add(i);
				i++;
				Products.class.notifyAll();
			}
		}
	
	}
}

//消费者
class Consumer extends Thread{
	@Override
	public void run() {
		while (true) {
			synchronized (Products.class) {
				while (Products.products.isEmpty()) {
					System.out.println("仓库为空");
					try {
						Products.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() +"消费的产品编号 : " + Products.products.remove()); 
				Products.class.notifyAll(); //唤醒生产者线程生产产品
			}
		}
	}
}