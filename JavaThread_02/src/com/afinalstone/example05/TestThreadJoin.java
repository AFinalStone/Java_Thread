package com.afinalstone.example05;

public class TestThreadJoin {
    public static void main(String args[]) {
        MyThread_Join thread2 = new MyThread_Join("MyThread_Join");
        // �ڴ���һ���µ��̶߳����ͬʱ������̶߳�������Ϊmythread
        thread2.start();// �����߳�
        try {
            thread2.join();// ����join()�����ϲ��̣߳������߳�mythread�ϲ������߳�����
            // �ϲ��̺߳󣬳����ִ�еĹ��̾��൱���Ƿ����ĵ��õ�ִ�й���
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i <= 5; i++) {
            System.out.println("I am main Thread");
        }
    }
}

