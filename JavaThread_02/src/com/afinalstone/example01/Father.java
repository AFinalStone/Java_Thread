package com.afinalstone.example01;

import com.afinalstone.MyLock;

public class Father extends Thread {

    public void run() {
        for (int i=0; i<3; i++){
            synchronized (MyLock.lock02_money) {
                System.out.println("Father：爸爸有零花钱");
                try {
                    MyLock.lock02_money.wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (MyLock.lock02_reportCart) {
                System.out.println("Father：爸爸想要儿子的成绩单");
            }
        }


    }
}
