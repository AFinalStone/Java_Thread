package com.afinalstone.example05;

import java.util.Date;

class MyThread_Sleep extends Thread {
    boolean flag = true;// 定义一个标记，用来控制循环的条件

    public void run() {
        /*
         * 注意：这里不能在run()方法的后面直接写throw Exception来抛异常， 
         * 因为现在是要重写从Thread类继承而来的run()方法,重写方法不能抛出比被重写的方法的不同的异常。
         *  所以这里只能写try……catch()来捕获异常
         */
        while (flag) {
            System.out.println("==========" + new Date().toLocaleString() + "===========");
            try {
                /*
                 * 静态方法的调用格式一般为“类名.方法名”的格式去调用 在本类中声明的静态方法时调用时直接写静态方法名即可。 当然使用“类名.方法名”的格式去调用也是没有错的
                 */
                // MyThread_Sleep.sleep(1000);//使用“类名.方法名”的格式去调用属于本类的静态方法
                sleep(1000);//睡眠的时如果被打断就会抛出InterruptedException异常
                // 这里是让这个新开辟的线程每隔一秒睡眠一次，然后睡眠一秒钟后再次启动该线程
                // 这里在一个死循环里面每隔一秒启动一次线程，每个一秒打印出当前的系统时间
            } catch (InterruptedException e) {
                /*
                 * 睡眠的时一盘冷水泼过来就有可能会打断睡眠 
                 * 因此让正在运行线程被一些意外的原因中断的时候有可能会抛被打扰中断(InterruptedException)的异常
                 */
                return;
                // 线程被中断后就返回，相当于是结束线程
            }
        }
    }
}