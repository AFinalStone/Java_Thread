### Java多线程(下篇)

一、死锁
1.同步锁 解决了线程安全问题，但会造成性能低下，还可能会引发一个问题（罕见）：死锁
2.
a.一个地痞子死后，来到了地狱，到了吃饭的时候，他发现饭桌上面的饭菜非常丰盛，然后好多人围着一张大桌子，一起吃饭，饭菜都上齐了，非常美味，
他们非常饿，开吃吧...但是只有两支筷子，而且是两个人同时各拿一支筷子...如果没有人愿意共享自己的筷子，那么他们就只能饿着...看着...馋着...留着口水.煎熬着...

b.爸爸说：“给我成绩单，就给你零花钱”，儿子说：“给我零花钱，就给你成绩单”，如果两人互不相让...
3.多个线程之间彼此占用对方想使用的资源
4.要使用非常规的手段演示b
5.分析b案例
	a.爸爸要成绩单    和   儿子要零花钱   这两个事情是同时发生的      多线程
	b.爸爸是一个线程       儿子是一个线程
	c.嵌套锁    +  交叉锁
	
```java

public class Son extends Thread {

    public void run() {

        for (int i = 0; i < 3; i++) {
            synchronized (MyLock.lock02_reportCart) {
                System.out.println("son：儿子有成绩单");
                try {
                    com.afinalstone.MyLock.lock02_reportCart.wait(5000);
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
	
二、解决死锁问题 
1.同步代码块，一旦某个线程执行了这个同步代码块，该代码块会自动上锁，当前线程把代码块里面所有的代码全部执行完，锁会自动解开
2.解决思路：不能等着自然解锁，而是有程序员主动的、及时的释放锁(解锁-开锁)
3.开锁的方法：wait()    wait(long)  开锁    在Object类中
4.该方法的作用：
	a.释放锁
	b.让当前线程休息
	
5.sleep()方法也可以让当前线程休息，没有释放锁的功能
6.任意对象都有一把锁，也有解锁的方法

三、notify方法
1.无参的wait()一旦执行了，会造成当前线程一直睡.....
2.notify()  唤醒某个被wait()的线程
3.自身无法唤醒自身
4.wait()和notify()必须使用的是同一把锁
5.之前的同步代码块是解决线程安全问题，还可以实现线程间的通信（打电话、发消息）
6.结合wait()和notify()并依靠同一把锁，可以实现线程间的通信(可不是互相发消息)。
     锁相当于中间人的作用，两个线程必须用同一把锁(认识同一个中间人)


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

public class Thread2 extends Thread{        //唤醒Thread1的线程
	public void run(){
		for(int j=0;j<10;j++){
			synchronized (MyLock.lock01_thread) {
				try {
					MyLock.lock01_thread.notify();
					System.out.println("唤醒");
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

![结果](picture/001.png)


四、生产者消费者模式
1.研究什么问题？农夫不停的摘水果放到框里，小孩不停的从框里拿水果吃
2.生产速度    跟   消费速度
3.农夫和小孩都需要依靠wait()和notify()调节进度

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
				System.out.println("小孩吃了一个水果，还有" + Factory.numOfFactory.size() + "个水果");
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
				System.out.println("水果场生产一个水果，现在有" + Factory.numOfFactory.size()
						+ "个水果");
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
	public static ArrayList<Integer> numOfFactory = new ArrayList<>();  //规定长度不能超过30
}

public class TestChild_FruitFactory {

	public static void main(String[] args) throws Exception {
		new FruitFactory().start();
		new Child().start();
	}

}

```

五、线程状态图


六、单例设计模式
1.实例化    实例
2.单个实例   只能创建出来一个对象
3.步骤
a.限制构造方法
b.把创建对象的代码放到一个静态的方法中并返回这个对象
c.增加一个静态属性，当该属性的值为null时才创建对象
4.懒汉式这种写法是否存在线程安全问题？会存在
5.只需要把getInstance方法改为同步方法即可解决线程安全问题
6.饿汉式没有线程安全问题，因此推荐使用
7.一般情况，懒汉式更常见

```java
//饿汉式
public class Student_hunger {
	private static Student_hunger s=new Student_hunger();
	
	private Student_hunger() {
	}
	
	public static Student_hunger getInstance()
	{
		return s;
	}
}

//懒汉式
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









