package com.afinalstone;

/**
 * 实现Runnable接口，并不是生产线类
 */
public class T02_RunnableStudent implements Runnable{

	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName()+"在看第"+i+"页书");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
