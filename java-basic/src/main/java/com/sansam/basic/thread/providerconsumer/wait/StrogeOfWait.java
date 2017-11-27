package com.sansam.basic.thread.providerconsumer.wait;

import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sansam.basic.thread.providerconsumer.Stroge;

public class StrogeOfWait implements Stroge{
	private static Logger logger = LoggerFactory.getLogger(StrogeOfWait.class);
	
	private static final LinkedList<Object> list = new LinkedList<Object>();
	
	/**
	 * 生产
	 * @param num
	 */
	public void produce(int num) {
		synchronized (list) {
			while(list.size() + num > MAX_SIZE) {
				logger.info("生产数量 ："+ num +" ，目前库存 ： "+ list.size() +" 大于 "+ MAX_SIZE +" 不能生产！");
				try {
					list.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			for(int i = 0; i < num ; i++) {
				list.add(new Object());
			}
			logger.info("生产数量 ："+ num +" ，目前库存 ： "+ list.size() +" 生产完毕");
			list.notifyAll();
		}
	}
	
	/**
	 * 消费
	 * @param num
	 */
	public void consume(int num) {
		synchronized (list) {
			while(list.size() - num < 0) {
				logger.info("消费数量 ："+ num +" ，目前库存 ： "+ list.size() +" 小于0 不能消费！");
				try {
					list.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			for(int i = 0; i < num ; i++) {
				list.remove(i);
			}
			logger.info("消费数量 ："+ num +" ，目前库存 ： "+ list.size() +" 消费完毕");
			list.notifyAll();
		
			
		}
	}

}
