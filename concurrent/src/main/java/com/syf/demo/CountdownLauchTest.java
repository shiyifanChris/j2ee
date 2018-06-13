package com.syf.demo;

import java.util.concurrent.CountDownLatch;

/**
 * Created by shiyifan on 2018/3/4.
 *
 * @author shiyifan
 * @date 2018/03/04
 */
public class CountdownLauchTest {

	static CountDownLatch countDownLatch = new CountDownLatch(5);

	static class Boss implements Runnable{
		@Override
		public void run() {
			System.out.println("等人齐准备开会");
			try {
				countDownLatch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("人到齐了，开会吧！");
		}
	}
	static class Employee implements Runnable{
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName()+"到了   。。。。");
			try {
				countDownLatch.countDown();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Boss boss = new Boss();
		new Thread(boss).start();
		for (int i=0;i<5;i++){
			new Thread(new Employee()).start();
		}

	}
}
