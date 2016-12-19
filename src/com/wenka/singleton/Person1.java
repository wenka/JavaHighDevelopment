package com.wenka.singleton;

public class Person1 {

	private final static Person1 PERSON1 = new Person1();

	private Person1() {

	}

	public static Person1 getInstance() {
		return PERSON1;
	}
}
