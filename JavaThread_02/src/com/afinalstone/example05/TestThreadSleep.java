package com.afinalstone.example05;

public class TestThreadSleep {
    public static void main(String args[]) {
        MyThread_Sleep thread = new MyThread_Sleep();
        thread.start();//����start()���������¿��ٵ��߳�
        try {
            /*Thread.sleep(10000);
            sleep()��������Thread������������һ����̬��������˿���ʹ��Thread.sleep()�ĸ�ʽ���е���
            */
            /*MyThread_Sleep.sleep(10000);
            MyThread��̳���Thread�࣬��ȻҲ�̳���sleep()����������Ҳ����ʹ��MyThread.sleep()�ĸ�ʽ���е���
            */
            /*��̬�����ĵ��ÿ���ֱ��ʹ�á�����.��̬��������
              ���ߡ����������.��̬���������ķ�ʽ������*/
            MyThread_Sleep.sleep(10000);
            System.out.println("���߳�˯����10���ֺ��ٴ�������");
            //��main()���������������һ����ľ�̬����ʱ����Ҫʹ�á���̬�������ڵ���.��̬�����������ַ�ʽ������
            /*
            ���������������߳�˯��10����
            ���ĸ��߳����������sleep()���������ĸ��߳�˯�ߣ��������������߳�˯���ˡ�
            */
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //thread.interrupt();//ʹ��interrupt()����ȥ������һ���̵߳�ִ�в�����һ���ܺõ�����
        thread.flag = false;//�ı�ѭ��������������ѭ��
        /**
         * ������InterruptedExceptionʱ��ֱ�Ӱ�ѭ������������Ϊfalse�����˳���ѭ����
         * �̶����������̵߳�ִ�У�����һ�ֱȽϺõĽ������̵߳�����
         */
        /**
         * ����interrupt()�������������е��̴߳��
         �൱�������߳�һ����ˮ����ȥ������ִ�з��̴߳����
         ���̱߳����֮��ͻ���InterruptedException�쳣�������ͻ�ִ��return��䷵�أ��������̵߳�ִ��
         ��������ķ��߳���ִ����10����֮��ͽ��������̵߳�ִ��
         */
    }
}

