### Java���߳�(��ƪ)

һ������

1.ͬ���� ������̰߳�ȫ���⣬����������ܵ��£������ܻ�����һ�����⣨������������

2.����

a.һ����Ʀ�����������˵��������˳Է���ʱ�������ַ�������ķ��˷ǳ���ʢ��Ȼ��ö���Χ��һ�Ŵ����ӣ�һ��Է������˶������ˣ��ǳ���ζ��
���Ƿǳ��������԰�...����ֻ����֧���ӣ�������������ͬʱ����һ֧����...���û����Ը�⹲���Լ��Ŀ��ӣ���ô���Ǿ�ֻ�ܶ���...����...����...���ſ�ˮ.�尾��...

b.�ְ�˵�������ҳɼ������͸����㻨Ǯ��������˵���������㻨Ǯ���͸���ɼ�������������˻�������...

3.����߳�֮��˴�ռ�öԷ���ʹ�õ���Դ

4.Ҫʹ�÷ǳ�����ֶ���ʾb

5.����b����
	
a.�ְ�Ҫ�ɼ���    ��   ����Ҫ�㻨Ǯ   ������������ͬʱ������      ���߳�
	
b.�ְ���һ���߳�       ������һ���߳�
	
c.Ƕ����    +  ������
	
```java

public class Son extends Thread {

    public void run() {

        for (int i = 0; i < 3; i++) {
            synchronized (MyLock.lock02_reportCart) {
                System.out.println("son�������гɼ���");
                try {
                    com.afinalstone.MyLock.lock02_reportCart.wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (MyLock.lock02_money) {
                    System.out.println("son��������Ҫ�ְֵ��㻨Ǯ");
                }
            }
        }

    }

}

public class Father extends Thread {

    public void run() {
        for (int i=0; i<3; i++){
            synchronized (MyLock.lock02_money) {
                System.out.println("Father���ְ����㻨Ǯ");
                try {
                    MyLock.lock02_money.wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (MyLock.lock02_reportCart) {
                System.out.println("Father���ְ���Ҫ���ӵĳɼ���");
            }
        }


    }
}


public class MyLock {
	public static Object lock02_money = new Object();
	public static Object lock02_reportCart = new Object();
}

public class TestFatherSon {

	public static void main(String[] args) {
		new Father().start();
		new Son().start();
	}

}


```
	
��������������� 

1.ͬ������飬һ��ĳ���߳�ִ�������ͬ������飬�ô������Զ���������ǰ�̰߳Ѵ�����������еĴ���ȫ��ִ���꣬�����Զ��⿪

2.���˼·�����ܵ�����Ȼ�����������г���Ա�����ġ���ʱ���ͷ���(����-����)

3.�����ķ�����wait()    wait(long)  ����    ��Object����

4.�÷��������ã�

a.�ͷ���

b.�õ�ǰ�߳���Ϣ
	
5.sleep()����Ҳ�����õ�ǰ�߳���Ϣ��û���ͷ����Ĺ���

6.���������һ������Ҳ�н����ķ���

����notify����

1.�޲ε�wait()һ��ִ���ˣ�����ɵ�ǰ�߳�һֱ˯.....

2.notify()  ����ĳ����wait()���߳�

3.�����޷���������

4.wait()��notify()����ʹ�õ���ͬһ����

5.֮ǰ��ͬ��������ǽ���̰߳�ȫ���⣬������ʵ���̼߳��ͨ�ţ���绰������Ϣ��

6.���wait()��notify()������ͬһ����������ʵ���̼߳��ͨ��(�ɲ��ǻ��෢��Ϣ)��
     ���൱���м��˵����ã������̱߳�����ͬһ����(��ʶͬһ���м���)


```java

public class Thread1 extends Thread{
	public void run() {
		
		for (int i = 1; i <= 20; i++) {
			synchronized (MyLock.lock01_thread) {
				System.out.println(i);
				if(i%5==0)
				{
					try {
						MyLock.lock01_thread.notify();
						MyLock.lock01_thread.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}		
		}
	}
}

public class Thread2 extends Thread{        //����Thread1���߳�
	public void run(){
		for(int j=0;j<10;j++){
			synchronized (MyLock.lock01_thread) {
				try {
					MyLock.lock01_thread.notify();
					System.out.println("����");
					MyLock.lock01_thread.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
}

public class TestWaitNotify {

	public static void main(String[] args) {
		Thread1 t1=new Thread1();
		t1.start();
		Thread2 t2=new Thread2();
		t2.start();
	}

}

```

![���](picture/���01.png)


�ġ�sleep����ʹ��ʵ��

```java

public class ThreadSleep {
    public static void main(String args[]) {
        MyThread thread = new MyThread();
        thread.start();//����start()���������¿��ٵ��߳�
        try {
            /*Thread.sleep(10000);
            sleep()��������Thread������������һ����̬��������˿���ʹ��Thread.sleep()�ĸ�ʽ���е���
            */
            /*MyThread.sleep(10000);
            MyThread��̳���Thread�࣬��ȻҲ�̳���sleep()����������Ҳ����ʹ��MyThread.sleep()�ĸ�ʽ���е���
            */
            /*��̬�����ĵ��ÿ���ֱ��ʹ�á�����.��̬��������
              ���ߡ����������.��̬���������ķ�ʽ������*/
            MyThread.sleep(10000);
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

class MyThread extends Thread {
    boolean flag = true;// ����һ����ǣ���������ѭ��������

    public void run() {
        /*
         * ע�⣺���ﲻ����run()�����ĺ���ֱ��дthrow Exception�����쳣�� 
         * ��Ϊ������Ҫ��д��Thread��̳ж�����run()����,��д���������׳��ȱ���д�ķ����Ĳ�ͬ���쳣��
         *  ��������ֻ��дtry����catch()�������쳣
         */
        while (flag) {
            System.out.println("==========" + new Date().toLocaleString() + "===========");
            try {
                /*
                 * ��̬�����ĵ��ø�ʽһ��Ϊ������.���������ĸ�ʽȥ���� �ڱ����������ľ�̬����ʱ����ʱֱ��д��̬���������ɡ� ��Ȼʹ�á�����.���������ĸ�ʽȥ����Ҳ��û�д��
                 */
                // MyThread.sleep(1000);//ʹ�á�����.���������ĸ�ʽȥ�������ڱ���ľ�̬����
                sleep(1000);//˯�ߵ�ʱ�������Ͼͻ��׳�InterruptedException�쳣
                // ������������¿��ٵ��߳�ÿ��һ��˯��һ�Σ�Ȼ��˯��һ���Ӻ��ٴ��������߳�
                // ������һ����ѭ������ÿ��һ������һ���̣߳�ÿ��һ���ӡ����ǰ��ϵͳʱ��
            } catch (InterruptedException e) {
                /*
                 * ˯�ߵ�ʱһ����ˮ�ù������п��ܻ���˯�� 
                 * ��������������̱߳�һЩ�����ԭ���жϵ�ʱ���п��ܻ��ױ������ж�(InterruptedException)���쳣
                 */
                return;
                // �̱߳��жϺ�ͷ��أ��൱���ǽ����߳�
            }
        }
    }
}

```
![���](picture/���02.png)

�塢join����ʹ��ʵ��

```java
public class TestThreadJoin {
    public static void main(String args[]) {
        MyThread_Join thread2 = new MyThread_Join("MyThread_Join");
        // �ڴ���һ���µ��̶߳����ͬʱ������̶߳�������Ϊmythread
        thread2.start();// �����߳�
        try {
            thread2.join();// ����join()�����ϲ��̣߳������߳�mythread�ϲ������߳�����
            // �ϲ��̺߳󣬳����ִ�еĹ��̾��൱���Ƿ����ĵ��õ�ִ�й���
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i <= 5; i++) {
            System.out.println("I am main Thread");
        }
    }
}

class MyThread_Join extends Thread {
    MyThread_Join(String s) {
        super(s);
        /*
         * ʹ��super�ؼ��ֵ��ø���Ĺ��췽�� 
         * ����Thread������һ�����췽������public Thread(String name)�� 
         * ͨ�������Ĺ��췽�����Ը��¿��ٵ��߳����������ڹ����߳�
         */
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("I am a\t" + getName());
            // ʹ�ø���Thread���涨���
            //public final String getName()��Returns this thread's name.
            try {
                sleep(1000);// �����߳�ÿִ��һ�ξ�˯��1����
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

```
![���](picture/���03.png)

����yield����ʹ��ʵ��
```java
public class TestThreadYield {
    public static void main(String args[]) {
        MyThread_Yield t1 = new MyThread_Yield("t1");
        /* ͬʱ�������������߳�t1��t2��t1��t2ִ�еĶ���run()���� */
        /* ��������ִ�й������ܹ���3���߳��ڲ���ִ�У��ֱ�Ϊ���߳�t1��t2�Լ����߳� */
        MyThread_Yield t2 = new MyThread_Yield("t2");
        t1.start();// �������߳�t1
        t2.start();// �������߳�t2
        for (int i = 0; i <= 5; i++) {
            System.out.println("I am main Thread");
        }
    }
}

class MyThread_Yield extends Thread {
    MyThread_Yield(String s) {
        super(s);
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + "��" + i);
            if (i % 2 == 0) {
                yield();// ��ִ�е�i�ܱ�2����ʱ��ǰִ�е��߳̾��ó�������һ����ִ��run()�������߳�������ִ��
                /*
                 * �ڳ�������еĹ����п��Կ�����
                 * �߳�t1ִ�е�(i%2==0)��ʱ�ͻ��ó��߳���t2�߳�������ִ�� 
                 * ���߳�t2ִ�е�(i%2==0)��ʱҲ���ó��̸߳�t1�߳�����ִ��
                 */
            }
        }
    }
}
```
![���](picture/���04.png)

�ߡ�������������ģʽ

1.�о�ʲô���⣿ũ��ͣ��ժˮ���ŵ����С����ͣ�Ĵӿ�����ˮ����

2.�����ٶ�    ��   �����ٶ�

3.ũ���С������Ҫ����wait()��notify()���ڽ���

```java

public class Child extends Thread {

	public void run() {
		while (true) {
			synchronized (Factory.numOfFactory) {
				if(Factory.numOfFactory.size()==0)
				{
					try {
						Factory.numOfFactory.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Factory.numOfFactory.remove(0);
				Factory.numOfFactory.notify();
				System.out.println("С������һ��ˮ��������" + Factory.numOfFactory.size() + "��ˮ��");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

public class FruitFactory extends Thread{
	
	public void run(){
		while (true) {
			synchronized (Factory.numOfFactory) {
				
				if(Factory.numOfFactory.size()>=10)
				{
					try {
						Factory.numOfFactory.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Factory.numOfFactory.add(1);
				Factory.numOfFactory.notify();
				System.out.println("ˮ��������һ��ˮ����������" + Factory.numOfFactory.size()
						+ "��ˮ��");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

public class Factory {
	public static ArrayList<Integer> numOfFactory = new ArrayList<>();  //�涨���Ȳ��ܳ���30
}

public class TestChild_FruitFactory {

	public static void main(String[] args) throws Exception {
		new FruitFactory().start();
		new Child().start();
	}

}

```


�ˡ��������ģʽ

1.ʵ����    ʵ��

2.����ʵ��   ֻ�ܴ�������һ������

3.����

a.���ƹ��췽��

b.�Ѵ�������Ĵ���ŵ�һ����̬�ķ����в������������

c.����һ����̬���ԣ��������Ե�ֵΪnullʱ�Ŵ�������

4.����ʽ����д���Ƿ�����̰߳�ȫ���⣿�����

5.ֻ��Ҫ��getInstance������Ϊͬ���������ɽ���̰߳�ȫ����

6.����ʽû���̰߳�ȫ���⣬����Ƽ�ʹ��

7.һ�����������ʽ������

```java
//����ʽ
public class Student_hunger {
	private static Student_hunger s=new Student_hunger();
	
	private Student_hunger() {
	}
	
	public static Student_hunger getInstance()
	{
		return s;
	}
}

//����ʽ
public class Student_lazybones {

	private static Student_lazybones s=null;
	
	private Student_lazybones() {
	}
	
	public synchronized static Student_lazybones getInstance()
	{
		if(s==null)
		{
			s=new Student_lazybones();
		}
		return s;
	}

}
public class ThreadStudent extends Thread{
	
	public void run(){
		
		for (int i = 0; i < 10; i++) {
			Student_lazybones s= Student_lazybones.getInstance();
			System.out.println(s.hashCode());
		}
		
	}
}

public class Main {

	public static void main(String[] args) {
		testLazyBones();
		testHunger();
		testThreadStudent();
	}

	private static void testLazyBones(){
		Student_lazybones s1= Student_lazybones.getInstance();
		System.out.println(s1.hashCode());

		Student_lazybones s2= Student_lazybones.getInstance();
		System.out.println(s2.hashCode());
	}

	private static void testHunger(){
		Student_hunger ss1= Student_hunger.getInstance();
		System.out.println(ss1.hashCode());

		Student_hunger ss2= Student_hunger.getInstance();
		System.out.println(ss2.hashCode());
	}

	private static void testThreadStudent(){
		for (int i = 0; i < 3; i++) {
			new ThreadStudent().start();
		}
	}
}

```
��Ŀ��ַ��[������](https://github.com/AFinalStone/Java_Thread)










