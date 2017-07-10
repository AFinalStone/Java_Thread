package com.afinalstone.example05;

public class TestThreadSleep {
    public static void main(String args[]) {
        MyThread_Sleep thread = new MyThread_Sleep();
        thread.start();//调用start()方法启动新开辟的线程
        try {
            /*Thread.sleep(10000);
            sleep()方法是在Thread类里面声明的一个静态方法，因此可以使用Thread.sleep()的格式进行调用
            */
            /*MyThread_Sleep.sleep(10000);
            MyThread类继承了Thread类，自然也继承了sleep()方法，所以也可以使用MyThread.sleep()的格式进行调用
            */
            /*静态方法的调用可以直接使用“类名.静态方法名”
              或者“对象的引用.静态方法名”的方式来调用*/
            MyThread_Sleep.sleep(10000);
            System.out.println("主线程睡眠了10秒种后再次启动了");
            //在main()方法里面调用另外一个类的静态方法时，需要使用“静态方法所在的类.静态方法名”这种方式来调用
            /*
            所以这里是让主线程睡眠10秒种
            在哪个线程里面调用了sleep()方法就让哪个线程睡眠，所以现在是主线程睡眠了。
            */
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //thread.interrupt();//使用interrupt()方法去结束掉一个线程的执行并不是一个很好的做法
        thread.flag = false;//改变循环条件，结束死循环
        /**
         * 当发生InterruptedException时，直接把循环的条件设置为false即可退出死循环，
         * 继而结束掉子线程的执行，这是一种比较好的结束子线程的做法
         */
        /**
         * 调用interrupt()方法把正在运行的线程打断
         相当于是主线程一盆凉水泼上去把正在执行分线程打断了
         分线程被打断之后就会抛InterruptedException异常，这样就会执行return语句返回，结束掉线程的执行
         所以这里的分线程在执行完10秒钟之后就结束掉了线程的执行
         */
    }
}

