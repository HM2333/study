package com.huangming.study.designpattern.decoratePattern;

/**
 * @author :Hm
 * @date :2019-12-23 下午 9:32
 * @description :
 */
public class DecoratorMainTest {

	public static void main(String[] args) {
		Drink juice = new Juice();

		Drink iceJuice = new IceDecorator(juice);
		System.out.println(iceJuice.description()+" and price "+iceJuice.price());

		Drink bigCupIceJuice = new BigCupDecorator(iceJuice);
		System.out.println(bigCupIceJuice.description()+" and price "+bigCupIceJuice.price());
	}
}
