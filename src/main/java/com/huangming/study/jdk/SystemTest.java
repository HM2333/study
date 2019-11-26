package com.huangming.study.jdk;

/**
 * @author :Hm
 * @date :2019-09-28 下午 2:58
 * @description :
 */
public class SystemTest {

	public static void main(String[] args) {
		arrayCopy();
	}

	private static void arrayCopy() {
		int[] source = new int[]{1, 2, 3, 4, 5, 6};
		System.arraycopy(source, 3, source, 0, 3);
		for (int i = 0; i < source.length; i++) {
			System.out.print(source[i]);
		}
	}

}
