package com.wenka.singleton;

import org.junit.Test;

public class MainClass {

	@Test
	public void test1() {
		Person1 person1 = Person1.getInstance();
		System.out.println(person1);
	}
	
	@Test
	public void test2(){
		Person2 person2 = Person2.getInstance();
		System.out.println(person2);
	}
}
