package com.syf.demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by shiyifan on 2018/2/26.
 *
 * @author shiyifan
 * @date 2018/02/26
 */
public class CyclicBarrierTest {


	private static CyclicBarrier cyclicBarrier;

	static   class  CyclicThread implements Runnable{
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName()+"arrive !");
			try {
				cyclicBarrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		cyclicBarrier = new CyclicBarrier(5,()-> System.out.println("人齐了 ，开会吧!"));
		for (int i=0;i<=5;i++){
			CyclicThread cyclicThread = new CyclicThread();
			new Thread(cyclicThread).start();
		}
	}
}
