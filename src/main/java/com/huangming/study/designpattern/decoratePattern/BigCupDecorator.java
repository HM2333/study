package com.huangming.study.designpattern.decoratePattern;

/**
 * @author :Hm
 * @date :2019-12-23 下午 9:31
 * @description :
 */
public class BigCupDecorator extends Decorator {

	public BigCupDecorator(Drink drink) {
		super(drink);
	}

	@Override
	public String description() {
		return super.description()+" add BigCup ";
	}

	@Override
	public double price() {
		return super.price()+3;
	}
}
