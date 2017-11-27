package com.sansam.basic.thread.providerconsumer;

import com.sansam.basic.thread.providerconsumer.wait.StrogeOfWait;

public class Test {
	public static void main(String[] args) {
		Stroge stroge = new StrogeOfWait();
		int produceNum = 3;
		int consumeNum = 5;
		
		Thread thread1 = new Thread(new Provider(stroge,produceNum));
		Thread thread2 = new Thread(new Provider(stroge,produceNum));
		Thread thread3 = new Thread(new Provider(stroge,produceNum));
		
		Thread thread4 = new Thread(new Consumer(stroge,consumeNum));
		Thread thread5 = new Thread(new Consumer(stroge,consumeNum));
		Thread thread6 = new Thread(new Consumer(stroge,consumeNum));
		
		thread4.start();
		thread5.start();
		thread6.start();
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
