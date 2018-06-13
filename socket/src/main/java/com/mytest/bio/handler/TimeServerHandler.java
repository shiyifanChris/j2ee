package com.mytest.bio.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;

/**
 * Created by shiyifan on 2018/5/12.
 *
 * @author shiyifan
 * @date 2018/05/12
 */
public class TimeServerHandler implements Runnable{

	private Socket accept;

	public TimeServerHandler(Socket accept) {
		this.accept = accept;
	}


	@Override
	public void run() {
		try(BufferedReader in = new BufferedReader(new InputStreamReader(this.accept.getInputStream()));
		    PrintWriter out = new PrintWriter(this.accept.getOutputStream(),true);
		) {
			String body = null;
			String currentTime = null;
			while(true){
				body = in.readLine();
				if(body==null){
					break;
				}
				System.out.println("the time server receive order "+body);
				currentTime = LocalDateTime.now().toString();
				out.println(currentTime);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
