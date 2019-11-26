package com.huangming.study.jdk.collection.queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author :Hm
 * @date :2019-10-28 下午 7:58
 * @description :
 */
public class QueueTest {

	static Queue queue = new ArrayBlockingQueue(4);

	public static void main(String[] args) {
		queueToArray();
	}

	public static void queueAdd() {
		queue.add(1);
		queue.add(2);
		queue.add(3);
//		queue.add(5);//throw exception
		System.out.println(queue.add(4));
		System.out.println(queue.offer(5));
		System.out.println(queue.size());
	}

	public static void queueGet() {
//		queue.add(1);
//		queue.add(2);
//		queue.add(3);
//		System.out.println(queue.element());
//		System.out.println(queue.peek());
		System.out.println(queue.peek());//return null
		System.out.println(queue.element());//throw exception
	}

	public static void queueToArray(){
		queue.add(1);
		queue.add(2);
		queue.add(3);
		Integer [] integers = (Integer[]) queue.toArray(new Integer[]{});
		System.out.println(integers.length);
	}
}
