package com.huangming.study.designpattern.filterpattern;

import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author :Hm
 * @date :2019-09-26 下午 7:13
 * @description : 过滤器模式
 */
public class FilterPattern {

	public static void main(String[] args) {
		Filter nameFilter = new NameFilter();
		Filter ageFilter = new AgeFilter();
		Filter sexFilter = new SexFilter();

		List<Filter> filterList = new ArrayList<>(4);
		filterList.add(nameFilter);
		filterList.add(ageFilter);
		filterList.add(sexFilter);

		FilterChain filterChain = new FilterChainImp(filterList);

		FilterDemo demo1 = new FilterDemo("filter", 11, "woman");
		FilterDemo demo2 = new FilterDemo("one", 10, "woman");
		FilterDemo demo3 = new FilterDemo("two", 12, "man");
		FilterDemo demo4 = new FilterDemo("three", 13, "woman");

		List<FilterDemo> demos = new ArrayList<>(4);
		demos.add(demo1);
		demos.add(demo2);
		demos.add(demo3);
		demos.add(demo4);

		List<FilterDemo> result = filterChain.doFilter(demos);
		for (FilterDemo filterDemo : result) {
			System.out.println(filterDemo.toString());
		}
	}

}
