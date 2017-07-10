package com.afinalstone.example05;

public class TestThreadYield {
    public static void main(String args[]) {
        MyThread_Yield t1 = new MyThread_Yield("t1");
        /* 同时开辟了两条子线程t1和t2，t1和t2执行的都是run()方法 */
        /* 这个程序的执行过程中总共有3个线程在并行执行，分别为子线程t1和t2以及主线程 */
        MyThread_Yield t2 = new MyThread_Yield("t2");
        t1.start();// 启动子线程t1
        t2.start();// 启动子线程t2
        for (int i = 0; i <= 5; i++) {
            System.out.println("I am main Thread");
        }
    }
}

