package com.wenka.proxy.staticproxy;

public class CountImpl implements Count {

	@Override
	public void queryCount() {
		System.out.println("�鿴�˻��ķ���������");
	}

	@Override
	public void updateCount() {
		System.out.println("�޸��˻��ķ���������");
	}

}
