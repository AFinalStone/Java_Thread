package com.afinalstone.example05;

class MyThread_Join extends Thread {
    MyThread_Join(String s) {
        super(s);
        /*
         * 使用super关键字调用父类的构造方法 
         * 父类Thread的其中一个构造方法：“public Thread(String name)” 
         * 通过这样的构造方法可以给新开辟的线程命名，便于管理线程
         */
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("I am a\t" + getName());
            // 使用父类Thread里面定义的
            //public final String getName()，Returns this thread's name.
            try {
                sleep(1000);// 让子线程每执行一次就睡眠1秒钟
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}