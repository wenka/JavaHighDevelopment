package com.wenka.singleton;

public class Person2 {

	private static Person2 person2;

	private Person2() {

	}

	public synchronized static Person2 getInstance() {
		if (person2 == null) {
			person2 = new Person2();
		}
		return person2;
	}
}
