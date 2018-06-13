package com.demo.chapter2.attribute;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by shiyifan on 2018/4/11.
 *
 * @author shiyifan
 * @date 2018/04/11
 */
public class Sub  {
	public static int a = 4;

	public static void main(String[] args) throws Exception{
		//System.out.println(Sub.a);
		ClassLoader myclassLoader = new ClassLoader() {
			@Override
			public Class<?> loadClass(String name) throws ClassNotFoundException {
				try {
					String fileName = name.substring(name.lastIndexOf(".")+1);
					InputStream inputStream = getClass().getResourceAsStream(fileName);
					if(inputStream==null){
						return super.loadClass(name);
					}
					byte[] b = new byte[inputStream.available()];
					inputStream.read(b);
					return defineClass(fileName,b,0,b.length);
				} catch (IOException e) {
					e.printStackTrace();
					throw  new ClassNotFoundException(name);
				}
			}
		};
		Object obj = myclassLoader.loadClass("com.demo.chapter2.attribute.Sub").newInstance();
		System.out.println(obj.getClass());
		System.out.println(obj instanceof com.demo.chapter2.attribute.Sub);
	}
}
