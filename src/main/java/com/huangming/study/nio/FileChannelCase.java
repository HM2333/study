package com.huangming.study.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author :Hm
 * @date :2019-09-20 下午 4:19
 * @description :
 */
public class FileChannelCase {


	public static void main(String[] args) throws IOException {
//		fileChannelReadTest();
		fileChannelWriteTest();
	}

	private static void fileChannelWriteTest() throws IOException {
		RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\channelTest.txt", "rw");
		FileChannel fileChannel = randomAccessFile.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(20);
		String txt = "this is a test txt";
		buffer.put(txt.getBytes());
		int count = fileChannel.write(buffer);
		System.out.println(count);
		randomAccessFile.close();
	}

	private static void fileChannelReadTest() throws IOException {
		RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\SreamTxt.txt", "rw");
		FileChannel fileChannel = randomAccessFile.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(8);
		int count = fileChannel.read(buffer);
		while (count != -1) {
			buffer.flip();
			while (buffer.hasRemaining()) {
				System.out.print((char) buffer.get());
			}
			buffer.clear();
			count = fileChannel.read(buffer);
		}
		randomAccessFile.close();
	}
}
