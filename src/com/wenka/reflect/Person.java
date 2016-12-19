package com.wenka.reflect;

public class Person {

	private String name;
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Person(String name) {
		this(name, 20);
	}

	@SuppressWarnings("unused")
	private Person(Integer age) {
		this("zhangsan", age);
	}

	public Person() {

	}

	@SuppressWarnings("unused")
	private void work(int hours) {
		System.out.println(name + "������" + hours + "��Сʱ");
	}

	@SuppressWarnings("unused")
	private double salary() {
		return 5000;
	}
}
