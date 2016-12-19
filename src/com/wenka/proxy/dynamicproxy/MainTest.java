package com.wenka.proxy.dynamicproxy;

public class MainTest {
	public static void main(String[] args) {
		BookFacadeProxy bookFacadeProxy = new BookFacadeProxy();
		BookFacade target = (BookFacade) bookFacadeProxy.bind(new BookFacadeImpl());
		target.addBook();
		System.out.println(target.getClass());
	}
}
