package com.afinalstone;

/**
 * Created by AFinalStone on 2017/6/30.
 */
public class T03_ExampleSaleWindow {

    public void testSaleWindow(){
        T03_SaleWindow t03_saleWindow = new T03_SaleWindow();

        Thread t1 = new Thread(t03_saleWindow);   //窗口1
        Thread t2 = new Thread(t03_saleWindow);   //窗口2

        t1.start();
        t2.start();
    }

    public void testSaleWindowBySynchronized01(){
        T03_SaleWindowSynchronized01 sw = new T03_SaleWindowSynchronized01();

        Thread t1 = new Thread(sw);   //窗口1
        Thread t2 = new Thread(sw);   //窗口2

        t1.start();
        t2.start();
    }

    public void testSaleWindowBySynchronized02(){

        T03_SaleWindowSynchronized02 sw=new T03_SaleWindowSynchronized02();

        Thread t1=new Thread(sw);
        Thread t2=new Thread(sw);

        t1.start();
        t2.start();
    }
}
