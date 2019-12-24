package com.huangming.study.designpattern.decoratePattern;

/**
 * @author :Hm
 * @date :2019-12-23 下午 9:29
 * @description :
 */
public class IceDecorator extends Decorator {

	public IceDecorator(Drink drink) {
		super(drink);
	}

	@Override
	public String description() {
		return super.description()+" add Ice ";
	}

	@Override
	public double price() {
		return super.price()+2;
	}
}
