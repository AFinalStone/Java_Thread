package com.afinalstone.example02;

import com.afinalstone.MyLock;

public class Thread2 extends Thread{        //»½ÐÑThread1µÄÏß³Ì
	public void run(){
		for(int j=0;j<10;j++){
			synchronized (MyLock.lock01_thread) {
				try {
					MyLock.lock01_thread.notify();
					System.out.println("»½ÐÑ");
					MyLock.lock01_thread.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
}
