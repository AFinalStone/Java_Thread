package com.afinalstone;

/**
 * Created by AFinalStone on 2017/6/30.
 */
public class T02_ExampleRunnableAndThread {

    public void testRunnable() {
        Thread t1 =new Thread(new T02_RunnableStudent());   //������һ��������
        Thread t2 =new Thread(new T02_RunnableStudent());   //������һ��������

        t1.start();   //����
        t2.start();
    }

    public void testThread() {
        //�÷�ʽһʵ������ѧ��ͬʱ����(10ҳ/100ms)
        //���̱߳��
        //1.ͬʱ��ʲô��      ����    �ⲿ�ִ���Ӧ�÷���run������
        //2.��Щ����Ӧ�ó䵱������     ��������
        //3.Ӧ�ô�������������������

        T02_ThreadStudent ts1=new T02_ThreadStudent();   //������һ��������
        ts1.setName("����");
        T02_ThreadStudent ts2=new T02_ThreadStudent();  //������һ��������
        ts2.setName("����");

        ts1.start();
        ts2.start();

        //˼����Ϊʲô��ֱ�ӵ���run()���������ǵ���start()�����������̣߳�
        //run()��ʵ����һ������ͨ�ķ�������start()�����ڲ�������run()�����Ե���������ȥִ��
    }

}
