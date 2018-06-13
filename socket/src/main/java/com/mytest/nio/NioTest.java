package com.mytest.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * Created by shiyifan on 2018/5/12.
 *
 * @author shiyifan
 * @date 2018/05/12
 */
public class NioTest {

	public static void main(String[] args) {
		try {
			ServerSocketChannel server = ServerSocketChannel.open();
			server.bind(new InetSocketAddress(8080));
			Selector selector = Selector.open();
			server.register(selector, SelectionKey.OP_ACCEPT);
			server.configureBlocking(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
