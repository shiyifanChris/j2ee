package com.syf.demo;


import com.mysql.jdbc.Connection;

import java.util.LinkedList;

/**
 * Created by shiyifan on 2018/2/6.
 *
 * @author shiyifan
 * @date 2018/02/06
 * <p>
 * 模拟数据库连接池   指定时间内获取连接
 */
public class ConnectionPool {

	private LinkedList<Connection> pools = new LinkedList<>();

	//连接池大小
	public ConnectionPool(int size) {
		for (int i = 0; i < size; i++) {
			pools.add(ConnectionDriver.createConnection());
		}
	}

	/**
	 * 归还连接
	 *
	 * @param connection
	 */
	public void releaseConnection(Connection connection) {
		if (connection != null) {
			synchronized (pools) {
				pools.addLast(connection);//归还连接
				pools.notifyAll();
			}
		}
	}


	/**
	 * 获取连接
	 *
	 * @param time
	 * @return
	 */
	public Connection fetchConnection(long time) throws Exception {
		synchronized (pools) {
			if (time < 0) {//已经等待超时
				while (pools.isEmpty()) {
					pools.wait();
				}
				return pools.removeFirst();
			} else {
				long future = System.currentTimeMillis() + time;
				long remaining = time;
				while (pools.isEmpty() && remaining > 0) {
					pools.wait(remaining);
					remaining = future - System.currentTimeMillis();
				}
				Connection result = null;
				if (!pools.isEmpty()) {
					result = pools.removeFirst();
				}
				return result;
			}
		}
	}


}
