package com.afinalstone.example05;

class MyThread_Yield extends Thread {
    MyThread_Yield(String s) {
        super(s);
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + "：" + i);
            if (i % 2 == 0) {
                yield();// 当执行到i能被2整除时当前执行的线程就让出来让另一个在执行run()方法的线程来优先执行
                /*
                 * 在程序的运行的过程中可以看到，
                 * 线程t1执行到(i%2==0)次时就会让出线程让t2线程来优先执行 
                 * 而线程t2执行到(i%2==0)次时也会让出线程给t1线程优先执行
                 */
            }
        }
    }
}