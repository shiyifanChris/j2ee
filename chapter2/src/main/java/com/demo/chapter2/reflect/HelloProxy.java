package com.demo.chapter2.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by shiyifan on 2018/4/6.
 *
 * @author shiyifan
 * @date 2018/04/06
 */
public class HelloProxy implements InvocationHandler {

	private Object target;

	public void bind(Object target){
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("我是jdk的动态代理，准备sayhello");
		method.invoke(target, args);
		System.out.println("我是jdk的动态代理，已经sayhello");
		Object o = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
		return null;
	}

	public Object getInstance() {
		return  Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	public static void main(String[] args) {
		HelloService h = new HelloServiceImpl();
		HelloProxy proxy = new HelloProxy();
		proxy.bind(h);
		HelloService instance = (HelloService) proxy.getInstance();
		instance.sayHello("shiyifan");
	}
}
