package com.mytest.bio.server;

import com.mytest.bio.handler.TimeServerHandler;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by shiyifan on 2018/5/12.
 *
 * @author shiyifan
 * @date 2018/05/12
 */
public class TimeServer {

	public static void main(String[] args) {
		int port = 8080;
//		ServerSocket server = null;
		try(ServerSocket server = new ServerSocket(port)) {
			Socket accept = null;
			while (true){
				accept = server.accept();
				new Thread(new TimeServerHandler(accept)).start();
			}
		}catch (Exception e){

		}

	}

}
