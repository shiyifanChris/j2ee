package com.mytest.vnio;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by shiyifan on 2018/5/12.
 *
 * @author shiyifan
 * @date 2018/05/12
 */
public class TimeServerExecutePool {

	private ExecutorService executorService;

	public  TimeServerExecutePool(int maxPool,int queueSize){
		executorService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),maxPool,120L,
				TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(queueSize));
	}

	public void execute(Runnable task){
		executorService.execute(task);
	}
}
