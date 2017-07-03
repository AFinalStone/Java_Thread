package com.afinalstone;

public class T03_SaleWindowSynchronized02 implements Runnable {

	private int ticket = 10; // ��Ʊ�ı�� ������Դ

	public synchronized void sale() {

		if (ticket >= 1) {
			System.out.println(Thread.currentThread().getName() + "�������Ϊ"
					+ ticket + "�Ļ�Ʊ");
			ticket--;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("ûƱ��");
		}

	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			sale();
		}
	}

}
