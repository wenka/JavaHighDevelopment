package com.wenka.exception;

import javax.management.JMException;
import javax.swing.undo.CannotRedoException;

public class TestException {
	public static void main(String[] args) {

		int i = 5;
		int j = 0;

		System.out.println(i / j);// java.lang.ArithmeticException

		try {
			Class.forName("com.test.throwable.TestException");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		method1();

		try {
			method2();
		} catch (JMException e) {
			e.printStackTrace();
		}

		System.out.println("end...");
	}

	// java.lang.RuntimeException 的子类
	public static void method1() throws CannotRedoException {

	}

	// 直接是 Exception 的子类
	public static void method2() throws JMException {

	}
}
