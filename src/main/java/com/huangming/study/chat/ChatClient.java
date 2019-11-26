package com.huangming.study.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author :Hm
 * @date :2019-09-22 下午 8:06
 * @description :
 */
public class ChatClient {

	public static void main(String[] args) throws IOException, InterruptedException {
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.connect(new InetSocketAddress(9999));
		Thread.sleep(10000);
		String message = "hello world";
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		for (int i = 0;i<20;i++){
			buffer.put(message.getBytes());
			buffer.flip();
			while (buffer.hasRemaining()){
				socketChannel.write(buffer);
			}
			buffer.clear();
			Thread.sleep(30000);
		}
		Thread.sleep(30000);
	}

}
