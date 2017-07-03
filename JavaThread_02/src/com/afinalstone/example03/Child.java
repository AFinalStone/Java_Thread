package com.afinalstone.example03;

public class Child extends Thread {

	public void run() {
		while (true) {
			synchronized (Factory.numOfFactory) {
				if(Factory.numOfFactory.size()==0)
				{
					try {
						Factory.numOfFactory.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Factory.numOfFactory.remove(0);
				Factory.numOfFactory.notify();
				System.out.println("小孩吃了一个水果，还有" + Factory.numOfFactory.size() + "个水果");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}