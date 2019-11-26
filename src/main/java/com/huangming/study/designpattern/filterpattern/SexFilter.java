package com.huangming.study.designpattern.filterpattern;

import java.util.Iterator;
import java.util.List;

/**
 * @author :Hm
 * @date :2019-09-26 下午 8:15
 * @description :
 */
public class SexFilter implements Filter {

	private static final String SEX = "man";

	@Override
	public List<FilterDemo> doFilter(List<FilterDemo> filterDemo, FilterChain filterChain) {
		FilterDemo temp;
		Iterator<FilterDemo> iterator = filterDemo.iterator();
		while (iterator.hasNext()) {
			temp = iterator.next();
			if (SEX.equals(temp.getSex())) {
				iterator.remove();
			}
		}
		return filterChain.doFilter(filterDemo);
	}
}
