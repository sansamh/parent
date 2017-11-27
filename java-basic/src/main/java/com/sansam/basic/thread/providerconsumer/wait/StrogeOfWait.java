package com.sansam.basic.thread.providerconsumer.wait;

import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sansam.basic.thread.providerconsumer.Stroge;

public class StrogeOfWait implements Stroge{
	private static Logger logger = LoggerFactory.getLogger(StrogeOfWait.class);
	
	private static final LinkedList<Object> list = new LinkedList<Object>();
	
	/**
	 * ����
	 * @param num
	 */
	public void produce(int num) {
		synchronized (list) {
			while(list.size() + num > MAX_SIZE) {
				logger.info("�������� ��"+ num +" ��Ŀǰ��� �� "+ list.size() +" ���� "+ MAX_SIZE +" ����������");
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
			logger.info("�������� ��"+ num +" ��Ŀǰ��� �� "+ list.size() +" �������");
			list.notifyAll();
		}
	}
	
	/**
	 * ����
	 * @param num
	 */
	public void consume(int num) {
		synchronized (list) {
			while(list.size() - num < 0) {
				logger.info("�������� ��"+ num +" ��Ŀǰ��� �� "+ list.size() +" С��0 �������ѣ�");
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
			logger.info("�������� ��"+ num +" ��Ŀǰ��� �� "+ list.size() +" �������");
			list.notifyAll();
		
			
		}
	}

}
