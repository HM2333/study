package com.huangming.study.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author :Hm
 * @date :2019-09-21 下午 8:50
 * @description :
 */
public class ChatServer {

	private static Logger logger = LoggerFactory.getLogger(ChatServer.class);

	public static void main(String[] args) {
		try {
			Selector selector = Selector.open();
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.socket().bind(new InetSocketAddress(9999));
			serverSocketChannel.configureBlocking(false);
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			while (true) {
				selector.select();
				Set<SelectionKey> set = selector.selectedKeys();
				Iterator<SelectionKey> iterator = set.iterator();
				while (iterator.hasNext()) {
					SelectionKey selectionKey = iterator.next();
					if ((selectionKey.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
						ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
						SocketChannel socketChannel = channel.accept();
						System.out.println("Got connection from " + socketChannel);
						socketChannel.configureBlocking(false);
						socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
						iterator.remove();
					} else if ((selectionKey.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {
						SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
						System.out.println("receive message from " + socketChannel.getRemoteAddress() + ":");
						int readCount = 0;
						ByteBuffer buffer = ByteBuffer.allocate(1024);
						readCount = socketChannel.read(buffer);
						while (readCount >0) {
							buffer.flip();
							while (buffer.hasRemaining()) {
								System.out.print((char) buffer.get());
							}
							buffer.clear();
							readCount = socketChannel.read(buffer);
						}
						System.out.println();
						iterator.remove();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	public static void methodOne() throws IOException {
//		Selector selector = Selector.open();
//		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
//		serverSocketChannel.socket().bind(new InetSocketAddress(9999));
//		serverSocketChannel.configureBlocking(false);
//		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
//		Thread thread = new Thread(new LoopToGetSocketChannel(serverSocketChannel, selector));
//		thread.start();
//		while (true) {
//			int i = selector.select();
//			if (i == 0) {
//				continue;
//			}
//			Set<SelectionKey> set = selector.selectedKeys();
//			Iterator<SelectionKey> iterator = set.iterator();
//			while (iterator.hasNext()) {
//				SelectionKey selectionKey = iterator.next();
//				if (selectionKey.isAcceptable()) {
//					logger.error("channel is accept");
//				} else if (selectionKey.isConnectable()) {
//					logger.error("channel is connect");
//				} else if (selectionKey.isReadable()) {
//					logger.error("channel is read");
//				} else if (selectionKey.isWritable()) {
//					logger.error("channel is write");
//				} else {
//					logger.error("no status");
//				}
//			}
//		}
//	}

	private static boolean isInterestedInAccept(int interestedSet) {
		return SelectionKey.OP_ACCEPT == (interestedSet & SelectionKey.OP_ACCEPT);
	}

	static class LoopToGetSocketChannel implements Runnable {


		private int connectCount;
		private ServerSocketChannel serverSocketChannel;
		private Selector selector;
		private SocketChannel socketChannel;

		public LoopToGetSocketChannel(ServerSocketChannel serverSocketChannel, Selector selector) {
			this.serverSocketChannel = serverSocketChannel;
			this.selector = selector;
		}

		@Override
		public void run() {
			while (true) {
				try {
					socketChannel = serverSocketChannel.accept();
					if (socketChannel == null) {
						continue;
					}
					InetSocketAddress address = (InetSocketAddress) socketChannel.getRemoteAddress();
					System.out.println("host name: " + address.getHostName() + ",address : " + address.getAddress() + ",port :" + address.getPort() + " connecting now");
					socketChannel.configureBlocking(false);
					socketChannel.register(selector, SelectionKey.OP_ACCEPT);
					connectCount++;
				} catch (IOException e) {
					logger.error(e.toString() + "---", e);
				}
			}
		}

		public int getConnectCount() {
			return connectCount;
		}
	}
}
