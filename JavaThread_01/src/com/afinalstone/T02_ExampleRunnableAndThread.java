package com.afinalstone;

/**
 * Created by AFinalStone on 2017/6/30.
 */
public class T02_ExampleRunnableAndThread {

    public void testRunnable() {
        Thread t1 =new Thread(new T02_RunnableStudent());   //创建了一条生产线
        Thread t2 =new Thread(new T02_RunnableStudent());   //创建了一条生产线

        t1.start();   //启动
        t2.start();
    }

    public void testThread() {
        //用方式一实现两个学生同时看书(10页/100ms)
        //多线程编程
        //1.同时干什么事      看书    这部分代码应该放在run方法中
        //2.哪些名词应该充当生产线     生产线类
        //3.应该创建或启动几条生产线

        T02_ThreadStudent ts1=new T02_ThreadStudent();   //创建了一条生产线
        ts1.setName("张三");
        T02_ThreadStudent ts2=new T02_ThreadStudent();  //创建了一条生产线
        ts2.setName("李四");

        ts1.start();
        ts2.start();

        //思考：为什么不直接调用run()方法，而是调用start()方法来启动线程？
        //run()其实就是一个很普通的方法，而start()方法内部调用了run()，可以当成生产线去执行
    }

}
