package com.afinalstone.example05;

class MyThread_Yield extends Thread {
    MyThread_Yield(String s) {
        super(s);
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + "��" + i);
            if (i % 2 == 0) {
                yield();// ��ִ�е�i�ܱ�2����ʱ��ǰִ�е��߳̾��ó�������һ����ִ��run()�������߳�������ִ��
                /*
                 * �ڳ�������еĹ����п��Կ�����
                 * �߳�t1ִ�е�(i%2==0)��ʱ�ͻ��ó��߳���t2�߳�������ִ�� 
                 * ���߳�t2ִ�е�(i%2==0)��ʱҲ���ó��̸߳�t1�߳�����ִ��
                 */
            }
        }
    }
}