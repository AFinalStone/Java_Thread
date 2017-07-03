package com.afinalstone;


/**
 * 继承Thread，生产线类
 */
public class T02_ThreadStudent extends Thread {

	public void run(){   //同时要执行的代码
		for (int i = 1; i <= 10; i++) {
			System.out.println(getName()+"在看第"+i+"页书");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
