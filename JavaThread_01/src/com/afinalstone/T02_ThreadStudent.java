package com.afinalstone;


/**
 * �̳�Thread����������
 */
public class T02_ThreadStudent extends Thread {

	public void run(){   //ͬʱҪִ�еĴ���
		for (int i = 1; i <= 10; i++) {
			System.out.println(getName()+"�ڿ���"+i+"ҳ��");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
