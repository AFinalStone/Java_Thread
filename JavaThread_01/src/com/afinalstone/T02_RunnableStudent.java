package com.afinalstone;

/**
 * ʵ��Runnable�ӿڣ���������������
 */
public class T02_RunnableStudent implements Runnable{

	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName()+"�ڿ���"+i+"ҳ��");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
