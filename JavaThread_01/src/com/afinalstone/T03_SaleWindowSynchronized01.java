package com.afinalstone;

public class T03_SaleWindowSynchronized01 implements Runnable{
	
	private int  ticket = 10;   //火车票的编号     共享资源

	public void run() {
		
		for (int i = 0; i < 10; i++) {
			synchronized (this) {   //同步代码快
				if (ticket >= 1) {
					System.out.println(Thread.currentThread().getName()
							+ "在卖编号为" + ticket + "的火车票");
					ticket--;
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("没票了");
					break;
				}
			}
		}
	}

}
