package com.wenka.proxy.staticproxy;

public class CountImpl implements Count {

	@Override
	public void queryCount() {
		System.out.println("查看账户的方法》》》");
	}

	@Override
	public void updateCount() {
		System.out.println("修改账户的方法》》》");
	}

}
