package com.afinalstone.example05;

public class TestThreadYield {
    public static void main(String args[]) {
        MyThread_Yield t1 = new MyThread_Yield("t1");
        /* ͬʱ�������������߳�t1��t2��t1��t2ִ�еĶ���run()���� */
        /* ��������ִ�й������ܹ���3���߳��ڲ���ִ�У��ֱ�Ϊ���߳�t1��t2�Լ����߳� */
        MyThread_Yield t2 = new MyThread_Yield("t2");
        t1.start();// �������߳�t1
        t2.start();// �������߳�t2
        for (int i = 0; i <= 5; i++) {
            System.out.println("I am main Thread");
        }
    }
}

