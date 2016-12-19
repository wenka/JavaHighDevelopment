package com.wenka.annotation;

public class MainClass {
	public static void main(String[] args) {
		
		Fruit fruit = new Fruit();
		FruitInfoUtil.getFruitInfo(fruit.getClass());
	}
}
