package com.huangming.study.designpattern.decoratePattern;

/**
 * @author :Hm
 * @date :2019-12-23 下午 9:14
 * @description :
 */
public class Juice implements Drink{

	@Override
	public String description() {
		return "this is a Juice";
	}

	@Override
	public double price() {
		return 5;
	}
}
