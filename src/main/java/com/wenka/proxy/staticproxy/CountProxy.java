package com.wenka.proxy.staticproxy;

/**
 * 这是一个代理类 （增强 CountImpl 实现类）
 * 
 * @author wenka
 */
public class CountProxy {

	private Count count;

	public CountProxy(Count count) {
		this.count = count;
	}

	public void queryCount() {
		System.out.println("事务调用之前....");
		// 调用为委托类的方法
		count.queryCount();
		System.out.println("事务调用之后....");
	}

	public void updateCount() {
		System.out.println("事务调用之前....");
		// 调用为委托类的方法
		count.updateCount();
		System.out.println("事务调用之后....");
	}

}
