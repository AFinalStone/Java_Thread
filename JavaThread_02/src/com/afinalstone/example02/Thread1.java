package com.afinalstone.example02;

import com.afinalstone.MyLock;

public class Thread1 extends Thread{
	public void run() {
		
		for (int i = 1; i <= 20; i++) {
			synchronized (MyLock.lock01_thread) {
				System.out.println(i);
				if(i%5==0)
				{
					try {
						MyLock.lock01_thread.notify();
						MyLock.lock01_thread.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}		
		}
	}
}
