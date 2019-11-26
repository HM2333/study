package com.huangming.study.designpattern.filterpattern;

import java.util.List;

/**
 * @author :Hm
 * @date :2019-09-26 下午 7:19
 * @description :
 */
public interface Filter {

	List<FilterDemo> doFilter(List<FilterDemo> filterDemo, FilterChain filterChain);

}
