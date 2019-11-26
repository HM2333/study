package com.huangming.study.designpattern.filterpattern;

import java.util.List;

/**
 * @author :Hm
 * @date :2019-09-26 下午 8:24
 * @description :
 */
public class FilterChainImp implements FilterChain {

	private List<Filter> filters;

	private static int size;

	private static int currentSize = 0;

	public FilterChainImp(List<Filter> filters) {
		this.filters = filters;
		size = filters.size();
	}

	@Override
	public List<FilterDemo> doFilter(List<FilterDemo> filterDemos) {
		if (currentSize < size) {
			filterDemos = filters.get(currentSize++).doFilter(filterDemos, this);
		}
		return filterDemos;
	}
}
