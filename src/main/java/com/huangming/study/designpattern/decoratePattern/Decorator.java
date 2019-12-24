package com.huangming.study.designpattern.decoratePattern;

/**
 * @author :Hm
 * @date :2019-12-23 下午 9:18
 * @description :
 */
public abstract class Decorator implements Drink {

	private Drink drink;
	public Decorator(Drink drink){
		this.drink=drink;
	}


	@Override
	public String description() {
		return drink.description();
	}

	@Override
	public double price() {
		return drink.price();
	}
}
