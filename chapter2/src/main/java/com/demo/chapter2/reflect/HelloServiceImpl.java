package com.demo.chapter2.reflect;

/**
 * Created by shiyifan on 2018/4/6.
 *
 * @author shiyifan
 * @date 2018/04/06
 */
public class HelloServiceImpl   implements HelloService {
	public static int a = 2;
	@Override
	public void sayHello(String name) {
		System.out.println(name+",hello!");
	}
}
