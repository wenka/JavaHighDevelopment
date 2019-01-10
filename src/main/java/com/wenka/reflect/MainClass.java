package com.wenka.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class MainClass {

	// ͨ��һ�������������İ���������
	@Test
	public void testGetClass() {
		Demo demo = new Demo();
		System.out.println(demo.getClass());
	}

	// ��ȡClass�����
	@Test
	public void testGetInstance() throws ClassNotFoundException {
		Class<?> demo1 = null;
		Class<?> demo2 = null;
		Class<?> demo3 = null;

		demo1 = Class.forName("com.wenka.reflect.Demo");

		demo2 = new Demo().getClass();

		demo3 = Demo.class;

		System.out.println("demo1��" + demo1);
		System.out.println("demo2��" + demo2);
		System.out.println("demo3��" + demo3);
	}

	// ͨ���޲� �Ĺ��췽��ʵ��������
	@Test
	public void testGetInstance2() throws ClassNotFoundException {

		Class<?> Demo = Class.forName("com.wenka.reflect.Person");

		try {
			// �������޲εĹ��췽��
			Person person = (Person) Demo.newInstance();
			person.setAge(20);
			person.setName("A");
			System.out.println(person);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

	// ͨ�������вεĹ��췽������ʵ��
	@Test
	public void testGetInstance3() throws ClassNotFoundException {

		Class<?> demo = Class.forName("com.wenka.reflect.Person");

		// ����һ������ĳЩ Constructor ��������飬
		// ��Щ����ӳ�� Class ��������ʾ��������й������췽��
		Constructor<?>[] constructors = demo.getConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.println(constructor);
			/*
			 * public com.wenka.reflect.Person() public
			 * com.wenka.reflect.Person(java.lang.String,java.lang.Integer)
			 */
		}

		// ��ȡָ���Ĺ��췽��
		try {
			Person person = (Person) demo.getConstructor(String.class).newInstance("wangwu");
			System.out.println(person);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		// ���� Constructor �����һ�����飬��Щ����ӳ�� Class �����ʾ�������������й��췽����
		Constructor<?>[] constructors2 = demo.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors2) {
			System.out.println(constructor);
		}
		// ͨ��˽�й��췽������ʵ��
		try {
			Constructor<?> constructor = demo.getDeclaredConstructor(Integer.class);
			// ֵΪ true ��ָʾ����Ķ�����ʹ��ʱӦ��ȡ�� Java ���Է��ʼ�顣
			// ֵΪ false ��ָʾ����Ķ���Ӧ��ʵʩ Java ���Է��ʼ�顣
			constructor.setAccessible(true);
			Object newInstance = constructor.newInstance(20);
			System.out.println(newInstance);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	// ��ȡ�ֶ�
	@Test
	public void testGetField() throws ClassNotFoundException {
		Class<?> demo = Class.forName("com.wenka.reflect.Person");
		// demo.getFields(); //��ȡ��˽�е��ֶ�
		Field[] fields = demo.getDeclaredFields();// ��ȡ�����ֶ�
		for (Field field : fields) {
			System.out.println(field);
		}

		// ��ȡָ���ֶ�
		try {
			Field field = demo.getDeclaredField("age");
			field.setAccessible(true);
			Person person = new Person("AAAAAA");
			System.out.println(person);
			// field.set(obj, value);��ĳ������Ĵ�����������ֵ
			field.set(person, 100);
			System.out.println(person);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	// ��ȡ����
	@Test
	public void testGetMethod() throws ClassNotFoundException {
		Class<?> demo = Class.forName("com.wenka.reflect.Person");

		// ���ؼ̳еõ��ķ���
		Method[] methods = demo.getMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}

		System.out.println("-------------------------------");

		// ���ر���ķ���
		Method[] declaredMethods = demo.getDeclaredMethods();
		for (Method method : declaredMethods) {
			System.out.println(method.getName());
		}

		// ��ȡָ������
		try {
			Method work = demo.getDeclaredMethod("work", int.class);
			System.out.println(work);
			work.setAccessible(true);
			Person person = new Person("AAAA");
			work.invoke(person, 10);

			Method salary = demo.getDeclaredMethod("salary");
			salary.setAccessible(true);
			Object invoke = salary.invoke(person);
			System.out.println("�õ��˹��ʣ�" + invoke);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
