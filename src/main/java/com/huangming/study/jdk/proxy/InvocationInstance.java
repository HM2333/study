package com.huangming.study.jdk.proxy;

/**
 * @author :Hm
 * @date :2019-11-16 下午 8:02
 * @description :
 */
public class InvocationInstance implements InvocationInterface {

	public void localMethod(String s){
		System.out.println(s);
	}

	@Override
	public void invoke(String s) {
		System.out.println(s);
		System.out.println(1/0);
	}
}
