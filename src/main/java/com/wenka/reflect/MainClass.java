package com.wenka.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class MainClass {

	// 通过一个对象获得完整的包名和类名
	@Test
	public void testGetClass() {
		Demo demo = new Demo();
		System.out.println(demo.getClass());
	}

	// 获取Class类对象
	@Test
	public void testGetInstance() throws ClassNotFoundException {
		Class<?> demo1 = null;
		Class<?> demo2 = null;
		Class<?> demo3 = null;

		demo1 = Class.forName("com.wenka.reflect.Demo");

		demo2 = new Demo().getClass();

		demo3 = Demo.class;

		System.out.println("demo1：" + demo1);
		System.out.println("demo2：" + demo2);
		System.out.println("demo3：" + demo3);
	}

	// 通过无参 的构造方法实例化对象
	@Test
	public void testGetInstance2() throws ClassNotFoundException {

		Class<?> Demo = Class.forName("com.wenka.reflect.Person");

		try {
			// 必须有无参的构造方法
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

	// 通过其他有参的构造方法创建实例
	@Test
	public void testGetInstance3() throws ClassNotFoundException {

		Class<?> demo = Class.forName("com.wenka.reflect.Person");

		// 返回一个包含某些 Constructor 对象的数组，
		// 这些对象反映此 Class 对象所表示的类的所有公共构造方法
		Constructor<?>[] constructors = demo.getConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.println(constructor);
			/*
			 * public com.wenka.reflect.Person() public
			 * com.wenka.reflect.Person(java.lang.String,java.lang.Integer)
			 */
		}

		// 获取指定的构造方法
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

		// 返回 Constructor 对象的一个数组，这些对象反映此 Class 对象表示的类声明的所有构造方法。
		Constructor<?>[] constructors2 = demo.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors2) {
			System.out.println(constructor);
		}
		// 通过私有构造方法创建实例
		try {
			Constructor<?> constructor = demo.getDeclaredConstructor(Integer.class);
			// 值为 true 则指示反射的对象在使用时应该取消 Java 语言访问检查。
			// 值为 false 则指示反射的对象应该实施 Java 语言访问检查。
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

	// 获取字段
	@Test
	public void testGetField() throws ClassNotFoundException {
		Class<?> demo = Class.forName("com.wenka.reflect.Person");
		// demo.getFields(); //获取非私有的字段
		Field[] fields = demo.getDeclaredFields();// 获取所有字段
		for (Field field : fields) {
			System.out.println(field);
		}

		// 获取指定字段
		try {
			Field field = demo.getDeclaredField("age");
			field.setAccessible(true);
			Person person = new Person("AAAAAA");
			System.out.println(person);
			// field.set(obj, value);给某个对象的此属性设置新值
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

	// 获取方法
	@Test
	public void testGetMethod() throws ClassNotFoundException {
		Class<?> demo = Class.forName("com.wenka.reflect.Person");

		// 返回继承得到的方法
		Method[] methods = demo.getMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}

		System.out.println("-------------------------------");

		// 返回本类的方法
		Method[] declaredMethods = demo.getDeclaredMethods();
		for (Method method : declaredMethods) {
			System.out.println(method.getName());
		}

		// 获取指定方法
		try {
			Method work = demo.getDeclaredMethod("work", int.class);
			System.out.println(work);
			work.setAccessible(true);
			Person person = new Person("AAAA");
			work.invoke(person, 10);

			Method salary = demo.getDeclaredMethod("salary");
			salary.setAccessible(true);
			Object invoke = salary.invoke(person);
			System.out.println("得到了工资：" + invoke);
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
