package com.huangming.study.designpattern.filterpattern;

import java.util.Iterator;
import java.util.List;

/**
 * @author :Hm
 * @date :2019-09-26 下午 7:35
 * @description :
 */
public class NameFilter implements Filter {

	private static final String TARGET_NAME = "filter";

	@Override
	public List<FilterDemo> doFilter(List<FilterDemo> filterDemo, FilterChain filterChain) {
		FilterDemo temp;
		Iterator<FilterDemo> iterator = filterDemo.iterator();
		while (iterator.hasNext()) {
			temp = iterator.next();
			if (TARGET_NAME.equals(temp.getName())) {
				iterator.remove();
			}
		}
		return filterChain.doFilter(filterDemo);
	}
}
