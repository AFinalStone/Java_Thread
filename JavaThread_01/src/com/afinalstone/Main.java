package com.afinalstone;

/**
 * Created by AFinalStone on 2017/6/30.
 */
public class Main {
    public static void main(String[] args) {
//        test01();
//        test02();
        test03();
    }

    public static void test01(){
        //第一部分，测试普通循环和线程循环
        T01_ExampleFor t01_ExampleFor = new T01_ExampleFor();
        //测试普通的For循环
        t01_ExampleFor.testFor();
        //测试线程中的For循环
        t01_ExampleFor.testThreadFor();
    }

    public static void test02(){
        //第二部分，Thread和Runnable两者的区别
        T02_ExampleRunnableAndThread t02_exampleRunnableAndThread = new T02_ExampleRunnableAndThread();
//        t02_exampleRunnableAndThread.testThread();
        t02_exampleRunnableAndThread.testRunnable();
    }

    public static void test03(){
        //第三部分 普通线程和线程同步
        T03_ExampleSaleWindow t03_ExampleSaleWindow = new T03_ExampleSaleWindow();
        t03_ExampleSaleWindow.testSaleWindow();
//        t03_ExampleSaleWindow.testSaleWindowBySynchronized01();
//        t03_ExampleSaleWindow.testSaleWindowBySynchronized02();

    }
}
