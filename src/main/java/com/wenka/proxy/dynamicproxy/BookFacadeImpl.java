package com.wenka.proxy.dynamicproxy;

public class BookFacadeImpl implements BookFacade {

	@Override
	public void addBook() {
		System.out.println("增加图书的方法！");
	}

}
