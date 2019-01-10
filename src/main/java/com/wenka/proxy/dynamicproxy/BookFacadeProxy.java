package com.wenka.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BookFacadeProxy implements InvocationHandler {

	private Object target;

	public Object bind(Object target) {
		this.target = target;
		// Ҫ��һ���ӿ�
		// Proxy.newProxyInstance(loader, interfaces, h);
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;

		System.out.println("����ʼ������");

		// method.invoke(obj, args)
		method.invoke(target, args);

		System.out.println("�������������");

		return result;
	}

}
