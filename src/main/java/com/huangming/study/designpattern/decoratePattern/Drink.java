package com.huangming.study.designpattern.decoratePattern;

/**
 * @author :Hm
 * @date :2019-12-23 下午 8:57
 * @description :
 *
 *  装饰者模式
 *  1、被装饰者
 *  2、装饰器
 *  3、装饰者
 *  4、基类接口，定义基本行为
 *
 *
 *
 */
public interface Drink {

	public String description();

	public double price();
}
