package com.huangming.study.designpattern.filterpattern;

import java.util.List;

/**
 * @author :Hm
 * @date :2019-09-26 下午 7:16
 * @description :
 */
public interface FilterChain {

	List<FilterDemo> doFilter(List<FilterDemo> filterDemos);

}
