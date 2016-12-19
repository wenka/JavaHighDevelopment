package com.wenka.exception;

public class DoException {
	public static void main(String[] args) {

		System.out.println(method4());

		// method2();

		// try {
		// method1();
		// } catch (ClassNotFoundException e) {
		// System.out.println(e.getMessage());//ÏêÏ¸ÏûÏ¢×Ö·û´®
		// System.out.println(e.toString());
		// }

	}

	// Å×³öÒì³£
	public static void method1() throws ClassNotFoundException {

		Class<?> name = Class.forName("com.test.throwable.DoException2");

		System.out.println(name);
	}

	// try{...}catch(...){...}
	public static void method2() {
		try {
			Class<?> name = Class.forName("com.test.throwable.DoException2");
			System.out.println(name);
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}
	}

	// try{...}catch(...){...}
	public static double method3() {
		try {
			Class.forName("com.test.throwable.DoException2");
			return 1;
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
			return 2;
		}
	}

	// try{...}catch(...){...}finally{...}
	@SuppressWarnings("finally")
	public static double method4() {
		try {
			System.out.println(1/0);
			return 1;
		} catch (ArithmeticException e) {
			System.out.println(e.toString());
			return 2;
		}finally {
			return 3;
		}
	}
}
