package com.mytest.vnio;

import com.mytest.bio.handler.TimeServerHandler;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by shiyifan on 2018/5/12.
 *
 * 伪nio
 * @author shiyifan
 * @date 2018/05/12
 */
public class TimeServer {

	public static void main(String[] args) {
		int port = 8080;
//		ServerSocket server = null;
		try(ServerSocket server = new ServerSocket(port)) {
			Socket accept = null;
			TimeServerExecutePool pool = new TimeServerExecutePool(50,1000);
			while (true){
				accept = server.accept();
				pool.execute(new TimeServerHandler(accept));
			}
		}catch (Exception e){

		}
	}
}
