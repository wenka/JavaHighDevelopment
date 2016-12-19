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
	 *            账户余额
	 * @param price
	 *            商品价格
	 */
	public static void buy(double account, double price) {

		if (account < price) {
			throw new MyException("余额不足！");
		}

	}
}
