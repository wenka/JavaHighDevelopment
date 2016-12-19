package com.wenka.proxy.staticproxy;

/**
 * ����һ�������� ����ǿ CountImpl ʵ���ࣩ
 * 
 * @author wenka
 */
public class CountProxy {

	private Count count;

	public CountProxy(Count count) {
		this.count = count;
	}

	public void queryCount() {
		System.out.println("�������֮ǰ....");
		// ����Ϊί����ķ���
		count.queryCount();
		System.out.println("�������֮��....");
	}

	public void updateCount() {
		System.out.println("�������֮ǰ....");
		// ����Ϊί����ķ���
		count.updateCount();
		System.out.println("�������֮��....");
	}

}
