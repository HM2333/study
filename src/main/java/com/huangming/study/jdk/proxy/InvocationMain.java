package com.huangming.study.jdk.proxy;

import java.lang.reflect.Proxy;

/**
 * @author :Hm
 * @date :2019-11-16 下午 8:03
 * @description :
 */
public class InvocationMain {

	public static void main(String[] args) {
		InvocationInterface invocationInstance = new InvocationInstance();
		InvocationInterface proxy = (InvocationInterface) Proxy.newProxyInstance(InvocationMain.class.getClassLoader(), invocationInstance.getClass().getInterfaces(), new InvocationHandle<InvocationInterface>(invocationInstance));

		proxy.invoke("s");
	}
}
