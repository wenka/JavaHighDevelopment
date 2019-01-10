package com.wenka.proxy.staticproxy;

public class MainTest {
	public static void main(String[] args) {
		Count count = new CountImpl();
		CountProxy countProxy = new CountProxy(count);
		countProxy.queryCount();
		countProxy.updateCount();
	}
}
