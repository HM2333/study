package com.huangming.study.jdk.Map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author :Hm
 * @date :2019-10-25 下午 8:51
 * @description :
 */
public class LinkedHashMapTest {

	public static void main(String[] args) {
//		Map linkedHashMap = new LinkedHashMap(16, 0.75f, true);
//		linkedHashMap.put("1", "one");
//		linkedHashMap.put("2", "two");
//		linkedHashMap.put("3", "three");
//		linkedHashMap.put("4", "four");
//		System.out.println("-------------------- map init --------------------");
//		forEachMap(linkedHashMap);
//		linkedHashMap.get("1");
//		System.out.println("-------------------- map get --------------------");
//		forEachMap(linkedHashMap);
		System.out.println("-------------------- self map init --------------------");
		SelfLinkedHashMap selfLinkedHashMap = new SelfLinkedHashMap();
		selfLinkedHashMap.put("1", "one");
		selfLinkedHashMap.put("2", "two");
		selfLinkedHashMap.put("3", "three");
		selfLinkedHashMap.put("4", "four");
		forEachMap(selfLinkedHashMap);
		System.out.println("-------------------- self map get --------------------");
		selfLinkedHashMap.get("1");
		forEachMap(selfLinkedHashMap);
	}

	public static void forEachMap(Map map) {
		Iterator iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			System.out.println("key = " + entry.getKey() + " value = " + entry.getValue());
		}
	}

	static class SelfLinkedHashMap extends LinkedHashMap{
		@Override
		protected boolean removeEldestEntry(Map.Entry eldest) {
			System.out.println("key = " + eldest.getKey() + " value = " + eldest.getValue());
			return true;
		}
	}
}
