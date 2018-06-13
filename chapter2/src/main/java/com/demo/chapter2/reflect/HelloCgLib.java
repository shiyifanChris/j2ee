package com.demo.chapter2.reflect;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by shiyifan on 2018/4/6.
 *
 * @author shiyifan
 * @date 2018/04/06
 */
public class HelloCgLib implements MethodInterceptor{


	private Object target;

	public Object getInstance(Object target) {
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("我是cglib的动态代理，准备sayhello");
		Object invoke = proxy.invokeSuper(obj, args);
		System.out.println("我是cglib的动态代理，已经sayhello");
		return invoke;
	}

	public static void main(String[] args) {
		HelloServiceImpl h = new HelloServiceImpl();
		HelloCgLib proxy = new HelloCgLib();
		Object instance = proxy.getInstance(h);
		((HelloServiceImpl)instance).sayHello("shiyfian");
		System.out.println(instance.getClass().getName());
//		HelloServiceImpl instance = (HelloServiceImpl) proxy.getInstance(h);
//		instance.sayHello("shiyifan");
	}
}
