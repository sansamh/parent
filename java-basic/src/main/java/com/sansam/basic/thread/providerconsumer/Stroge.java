package com.sansam.basic.thread.providerconsumer;

public interface Stroge {
	
	int MAX_SIZE = 10;
	
	public void produce(int num);
	public void consume(int num);
}
