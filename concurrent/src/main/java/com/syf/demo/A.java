package com.syf.demo;

/**
 * Created by shiyifan on 2018/3/29.
 *
 * @author shiyifan
 * @date 2018/03/29
 */
public class A {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		A b,c=null;
		b  = c ;
		c = null;
		c = new A();
		c.setName("aa");
		System.out.println(b);
		System.out.println(c);
	}
}
