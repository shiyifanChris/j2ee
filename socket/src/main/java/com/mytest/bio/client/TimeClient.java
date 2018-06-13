package com.mytest.bio.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by shiyifan on 2018/5/12.
 *
 * @author shiyifan
 * @date 2018/05/12
 */
public class TimeClient {

	public static void main(String[] args) {
		int port = 8080;
		if(args!=null&&args.length>0){
			port = Integer.valueOf(args[0]);
		}
		try(Socket client = new Socket("127.0.0.1",port);
		    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		    PrintWriter out = new PrintWriter(client.getOutputStream(),true))
		{
			out.println("query time order");
			System.out.println("send order req success");
			String response = in.readLine();
			System.out.println("response is "+response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
