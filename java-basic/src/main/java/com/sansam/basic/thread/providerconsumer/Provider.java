package com.sansam.basic.thread.providerconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Provider implements Runnable{
	private static Logger logger = LoggerFactory.getLogger(Provider.class);
	
	private Stroge stroge;
	private int num;
	
	public Provider(Stroge stroge,int num) {
		this.stroge = stroge;
		this.num = num;
	}

	public void run() {
		doProduce();
	}
	
	private void doProduce() {
		stroge.produce(num);
	}

}
