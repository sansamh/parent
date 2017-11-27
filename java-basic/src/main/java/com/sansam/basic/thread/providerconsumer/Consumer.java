package com.sansam.basic.thread.providerconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Consumer implements Runnable {
	private static Logger logger = LoggerFactory.getLogger(Consumer.class);
	
	private Stroge stroge;
	private int num;
	
	public Consumer(Stroge stroge,int num) {
		this.stroge = stroge;
		this.num = num;
	}

	public void run() {
		logger.info("消费者 "+Thread.currentThread().getName() +" 准备消费 "+ num +"个产品");
		doConsume();
		logger.info("消费者 "+Thread.currentThread().getName() +" 消费完毕 "+ num +"个产品");
	}
	
	private void doConsume() {
		stroge.produce(num);
	}

}
