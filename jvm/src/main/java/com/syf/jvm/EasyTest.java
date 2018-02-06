package com.syf.jvm;

/**
 * Created by hasee on 2018/1/14.
 *
 * @author hasee
 * @date 2018/01/14
 */
public class EasyTest {

	public static int i = 1024;

	public static void main(String[] args) {
		byte[] b1 = new byte[2*i*i];
		byte[] b4 = new byte[4*i*i];
	}
}
