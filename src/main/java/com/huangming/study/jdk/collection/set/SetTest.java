package com.huangming.study.jdk.collection.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @author :Hm
 * @date :2019-10-28 下午 9:11
 * @description :
 */
public class SetTest {

	private static Set set = new HashSet();

	public static void main(String[] args) {
		setAddAndGet();
	}

	public static void setAddAndGet(){
		set.add("a");
		set.add("b");
		for (Object object : set){
			System.out.println(object);
		}
	}
}
