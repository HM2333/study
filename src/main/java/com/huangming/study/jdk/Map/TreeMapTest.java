package com.huangming.study.jdk.Map;

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * @author :Hm
 * @date :2019-10-30 下午 8:17
 * @description :
 */
public class TreeMapTest {

	static NavigableMap navigableMap = new TreeMap();

	public static void main(String[] args) {
//		firstEntry();
//		pollFirstEntry();
//		descendingMap();
//		subMap();
//		headMap();
//		tailMap();
		floorEntry();
//		ceilingEntry();
//		lowerEntry();

		//lowerEntry 与floorEntry的区别 lowerEntry返回小于key值的Entry对象，而floorEntry传入的key值存在的话则返回key值对应的Entry对象，否则返回小于key值的Entry对象。
	}

	public static void firstEntry() {
		navigableMap.put(1, 1);
		navigableMap.put(2, 2);
		navigableMap.put(9, 9);
		Map.Entry entry = navigableMap.firstEntry();
		navigableMap.remove(1);
		System.out.println("entry key " + entry.getKey() + " entry value " + entry.getValue());
		Map.Entry entry1 = navigableMap.firstEntry();
		System.out.println("after remove entry key " + entry1.getKey() + " entry value " + entry1.getValue());
	}

	public static void pollFirstEntry() {
		navigableMap.put(1, 1);
		navigableMap.put(2, 2);
		navigableMap.put(9, 9);
		Map.Entry entry = navigableMap.pollFirstEntry();
		System.out.println("entry key " + entry.getKey() + " entry value " + entry.getValue() + " and map's size " + navigableMap.size());
	}

	public static void descendingMap() {
		navigableMap.put(2, 2);
		navigableMap.put(1, 1);
		navigableMap.put(9, 9);
		forEachMap(navigableMap);
		NavigableMap map = navigableMap.descendingMap();
		forEachMap(map);
	}

	public static void subMap() {
		navigableMap.put(2, 2);
		navigableMap.put(1, 1);
		navigableMap.put(9, 9);
		NavigableMap map = navigableMap.subMap(1, true, 3, true);
		forEachMap(map);
		forEachMap(navigableMap);
	}

	public static void headMap() {
		navigableMap.put(2, 2);
		navigableMap.put(1, 1);
		navigableMap.put(9, 9);
		NavigableMap map = navigableMap.headMap(2, false);
		forEachMap(map);
	}

	public static void tailMap() {
		navigableMap.put(2, 2);
		navigableMap.put(1, 1);
		navigableMap.put(9, 9);
		NavigableMap map = navigableMap.tailMap(1, true);
		forEachMap(map);
	}

	public static void floorEntry() {
		navigableMap.put(2, 2);
		navigableMap.put(1, 1);
		navigableMap.put(9, 9);
		Map.Entry entry = navigableMap.floorEntry(9);
		System.out.println("entry key " + entry.getKey() + " entry value " + entry.getValue());
	}

	public static void ceilingEntry() {
		navigableMap.put(2, 2);
		navigableMap.put(1, 1);
		navigableMap.put(9, 9);
		Map.Entry entry = navigableMap.ceilingEntry(8);
		System.out.println("entry key " + entry.getKey() + " entry value " + entry.getValue());
	}

	public static void lowerEntry() {
		navigableMap.put(2, 2);
		navigableMap.put(1, 1);
		navigableMap.put(9, 9);
		Map.Entry entry = navigableMap.lowerEntry(9);
		System.out.println("entry key " + entry.getKey() + " entry value " + entry.getValue());
	}

	public static void forEachMap(NavigableMap map) {
		System.out.println("----------------------------------------------------------------------");
		Iterator iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			System.out.println("entry key " + entry.getKey() + " entry value " + entry.getValue());
		}
	}
}
