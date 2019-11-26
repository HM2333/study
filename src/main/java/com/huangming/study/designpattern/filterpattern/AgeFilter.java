package com.huangming.study.designpattern.filterpattern;

import java.util.Iterator;
import java.util.List;

/**
 * @author :Hm
 * @date :2019-09-26 下午 8:09
 * @description :
 */
public class AgeFilter implements Filter {

	private static final Integer AGE = 10;

	@Override
	public List<FilterDemo> doFilter(List<FilterDemo> filterDemo, FilterChain filterChain) {
		FilterDemo temp;
		Iterator<FilterDemo> iterator = filterDemo.iterator();
		while (iterator.hasNext()) {
			temp = iterator.next();
			if (AGE.equals(temp.getAge())) {
				iterator.remove();
			}
		}
		return filterChain.doFilter(filterDemo);
	}
}
