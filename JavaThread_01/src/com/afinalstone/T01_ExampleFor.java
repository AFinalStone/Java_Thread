package com.afinalstone;

/**
 * Created by Administrator on 2017/6/30.
 */
public class T01_ExampleFor {

    public void testFor() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hello");
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("world");
        }
    }

    public void testThreadFor() {

        T01_ThreadFor tf1 = new T01_ThreadFor();   //������һ��������
        System.out.println("id:"+tf1.getId());
		System.out.println("name:"+tf1.getName());
        T01_ThreadFor tf2 = new T01_ThreadFor();   //������һ��������
		System.out.println("id:"+tf2.getId());
		System.out.println("name:"+tf2.getName());

        tf1.start();   //����
        tf2.start();   //����
    }

}
//id:11
//name:Thread-0
//id:12
//name:Thread-1