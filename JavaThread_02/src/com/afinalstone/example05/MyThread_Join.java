package com.afinalstone.example05;

class MyThread_Join extends Thread {
    MyThread_Join(String s) {
        super(s);
        /*
         * ʹ��super�ؼ��ֵ��ø���Ĺ��췽�� 
         * ����Thread������һ�����췽������public Thread(String name)�� 
         * ͨ�������Ĺ��췽�����Ը��¿��ٵ��߳����������ڹ����߳�
         */
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("I am a\t" + getName());
            // ʹ�ø���Thread���涨���
            //public final String getName()��Returns this thread's name.
            try {
                sleep(1000);// �����߳�ÿִ��һ�ξ�˯��1����
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}