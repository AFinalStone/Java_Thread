### Java���߳�(��ƪ)

һ������
1.ͬ���� ������̰߳�ȫ���⣬����������ܵ��£������ܻ�����һ�����⣨������������
2.
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
                System.out.println(ccom.afinalstone.Fathernalstone.Father);
                try {
                    com.afinalstone.MyLock.lock02_money.wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (MyLock.lock02_reportCart) {
                System.out.prcom.afinalstone.Fathercom.afinalstone.Father);
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

![���](picture/001.png)


�ġ�������������ģʽ
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

�塢�߳�״̬ͼ


�����������ģʽ
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









