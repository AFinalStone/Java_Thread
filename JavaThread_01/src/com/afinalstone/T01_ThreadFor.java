package com.afinalstone;

public class T01_ThreadFor extends Thread {   //线程类   =  生产线

	public void run()
	{
		for (int i = 0; i < 10; i++) {
			System.out.println(getName()+"----"+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
