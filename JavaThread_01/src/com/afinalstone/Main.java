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
        //��һ���֣�������ͨѭ�����߳�ѭ��
        T01_ExampleFor t01_ExampleFor = new T01_ExampleFor();
        //������ͨ��Forѭ��
        t01_ExampleFor.testFor();
        //�����߳��е�Forѭ��
        t01_ExampleFor.testThreadFor();
    }

    public static void test02(){
        //�ڶ����֣�Thread��Runnable���ߵ�����
        T02_ExampleRunnableAndThread t02_exampleRunnableAndThread = new T02_ExampleRunnableAndThread();
//        t02_exampleRunnableAndThread.testThread();
        t02_exampleRunnableAndThread.testRunnable();
    }

    public static void test03(){
        //�������� ��ͨ�̺߳��߳�ͬ��
        T03_ExampleSaleWindow t03_ExampleSaleWindow = new T03_ExampleSaleWindow();
        t03_ExampleSaleWindow.testSaleWindow();
//        t03_ExampleSaleWindow.testSaleWindowBySynchronized01();
//        t03_ExampleSaleWindow.testSaleWindowBySynchronized02();

    }
}
