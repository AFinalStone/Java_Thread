package com.afinalstone.example01;

import com.afinalstone.MyLock;

public class Son extends Thread {

    public void run() {

        for (int i = 0; i < 3; i++) {
            synchronized (MyLock.lock02_reportCart) {
                System.out.println("son：儿子有成绩单");
                try {
                    MyLock.lock02_reportCart.wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (MyLock.lock02_money) {
                    System.out.println("son：儿子想要爸爸的零花钱");
                }
            }
        }

    }

}