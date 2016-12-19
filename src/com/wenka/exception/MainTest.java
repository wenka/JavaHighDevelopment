package com.wenka.exception;

public class MainTest {
	public static void main(String[] args) {
		try {
			buy(100, 150);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 * @param account
	 *            �˻����
	 * @param price
	 *            ��Ʒ�۸�
	 */
	public static void buy(double account, double price) {

		if (account < price) {
			throw new MyException("���㣡");
		}

	}
}
