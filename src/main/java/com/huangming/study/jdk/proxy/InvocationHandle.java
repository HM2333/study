package com.huangming.study.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author :Hm
 * @date :2019-11-16 下午 7:54
 * @description :
 */
public class InvocationHandle<T> implements InvocationHandler {

	private T t;

	public InvocationHandle(T t) {
		this.t = t;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return  method.invoke(t, args);
	}
}
