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
		logger.info("������ "+Thread.currentThread().getName() +" ׼������ "+ num +"����Ʒ");
		doConsume();
		logger.info("������ "+Thread.currentThread().getName() +" ������� "+ num +"����Ʒ");
	}
	
	private void doConsume() {
		stroge.produce(num);
	}

}
