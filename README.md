# Java并发程序模型

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 01MultiThreadTS<br>
* 创建线程的两种方式：
  * 继承Thread类。
  * 实现Runnable接口。
  <img width="380" height="300" src="http://www.codenest.cn/static/images/uml/001.jpg"/>

* 启动线程
```Java
Thread t2=new Thread(new RunnableImpl());
t2.start();
```
* 终止线程
  * 线程函数自然结束。
  * 使用thread.stop()方法结束，这种方法会造成数据不一致的问题，不推荐使用。
  * 在Thread子类或者Runnable实现中增加一个boolean类型的标志字段。
* 中断线程
  * 中断线程 —— public void Thread.interrupt() 
  * 判断线程是否被中断 —— public boolean Thread.isInterrupted() 
  * 判断当前线程是否被中断，并清除中断状态 —— public static boolean Thread.interrupted() 
  * 若线程处于Thread.sleep()状态，线程发生中断时会抛出`InterruptedException`，并`清除中断`状态。
* 方法清单
1. void ThreadChild.run();        
2. void Runnable.run();
3. void Thread.sleep(long millis) throws InterruptedException;
4. Thread Thread.currentThread();  //获取当前线程对象
5. Thread.interrupt();//实例方法，中断线程
6. boolean Thread.isInterrupted(); //实例方法判断线程是否中断
7. static boolean Thread.interrupted();//静态方法，判断线程是否中断并清除中断状态
8. void Thread.start(); 
9. void Thread.stop(); //终止线程，可能造成数据不一致问题，不建议使用

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 02ThreadWaitTS<br>
* Object.wait()<br>
　　调用该方法后，所在线程会发生等待,并加入该object的线程等待队列。<br>
* Object.notify()<br>
 　　调用该方法后，通知所有object等待队列的线程，随机选择一个线程，退出等待状态。
* UML关系
<img width="380" height="300" src="http://www.codenest.cn/static/images/uml/002.jpg"/>

* 注意
    * 调用notify()方法后，等待队列中结束等待状态的线程是随机挑选的，而notifyAll()方法会使等待队列中所有的线程都结束等待状态。
    * notyfy()和notifyAll()方法被调用后，都会释放对象锁。
    * wait()、notify()和notifyAll()方法继承自Object类，也就是说Java中所有的类都含有了这三种方法。
    * 在使用obj.wait()和obj.notify()时，必须先获取obj的对象锁，也就是是说wait()和notify()必须在synchronized(obj){}语句块之内使用。
* 方法清单
1. void Object.wait()
2. void Object.notify()
3. void Object.notifyAll()
4. long System.currentTimeMillis();//获取当前的时间戳的毫秒数

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 03BadSuspendTS<br>
* UML关系
<img width="380" height="300" src="http://www.codenest.cn/static/images/uml/003.jpg"/>

* void Thread.suspend()
　　用来挂起当前线程
* void Thread.resume()
　　用来唤醒被挂起的线程
* 注意
    * 不建议使用这两个方法
    * suspend和resume在被调用后，不会释放占有的对象锁，这样会影响其它使用该对象锁的线程。
    * 如果resume先于suspend被调用，会造成线程无限期的挂起。
* 方法清单
    * void suspend();
    * void resume();

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 04JoinYieldTS<br>
* UML关系
<img width="380" height="300" src="http://www.codenest.cn/static/images/uml/004.jpg"/>

* thread.join()  
　　等待线程结束。
* Thread.yield()  
　　静态方法，当前线程出让资源。
* 方法清单
    * void Thread.join()
    * static void Thread.yield()

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 05VolatileTS<br>
* volatile<br>
　　volatile主要用来保证声明变量在多线程中的可见性，保证在一个线程中进行修改后，另一个线程可以知道它已经被修改。但是它不能保证该变量的原子性，也就是说多线程同时修改变量时，不能保证得到预期结果。
  ```Java
  public volatile boolean ready;
  ```

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 06ThreadGroupTS<br>
* UML关系
<img width="380" height="300" src="http://www.codenest.cn/static/images/uml/005.jpg"/>

* 线程组<br>
　　线程组（ThreadGroup）是把线程在业务上的一个划分。
* 方法清单
    * TheadGroup(string); //线程组的构造函数，传入线程组的名称
    * Thread(ThreadGroup,Runnable,string); //线程的构造函数，将线程组作为一个参数传递给线程
    * ThreadGroup.getName(); //获取线程组的名称
    * ThreadGroup.activeCount(); //获取线程组中已经启动的线程的个数
    * ThreadGroup.list(); //打印出线程组和其包含的所有的线程的信息
    
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 07DeamonTS<br>
* UML关系
<img width="380" height="300" src="http://www.codenest.cn/static/images/uml/006.jpg"/>

* 线程分类
    * 用户线程 —— 系统的工作线程，完成这个程序需要完成的业务操作，默认创建的线程就是用户线程，即使主线程结束，只要用户线程的业务还没有做完，它就不会退出。
    * 守护线程 —— 守护应用程序的线程，将一个线程设置成守护线程后，随着主线程的结束，守护线程也会退出。设置线程t为守护线程：
    ```Java
    Thread t = new Thread();
    t.setDeamon(true);
    t.start();
    ```

* 方法清单
    * thread.setDemaon(Boolean)
    
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 08PriorityTS<br>
* UML关系
<img width="380" height="300" src="http://www.codenest.cn/static/images/uml/007.jpg"/>

* 线程优先级
    * 高优先级的线程在资源的竞争中有大概率争取到资源。设置线程优先级的代码如下：
     ```Java
     Thread t=new Thread();
     t.setPriority(10);
     ```
* 方法清单
    * Thread.setPriority(int);//参数的数字越高，优先级越高。

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 09SynchronizedTS<br>
* UML关系
<img width="380" height="300" src="http://www.codenest.cn/static/images/uml/008.jpg"/>

* synchronized<br>
　　synchronized实现线程的同步，他的工作是对同步的代码块加锁，使得每一次只能有一个线程进入同步块，从而保证线程间的安全。
  
* 三种加锁方式
    * 指定加锁对象，使用任意一个对象实例作为加锁对象，线程间共享该对象。
    ```java
    public static LockObjectRunnable lock = new LockObjectRunnable();
    synchronized(lock){
				 
			 }
    ```
    * 对实例方法加锁，当对Runnale的实现类的实例方法加锁时，需要保证创建线程时传入的是同一个该类的实例。
    ```java
    LockInstanceMethodRunnable run = new LockInstanceMethodRunnable();
		  Thread t3 = new Thread(run);
		  Thread t4 = new Thread(run);
    ```
    * 对静态方法加锁，当对Runnale的实现类的静态方法加锁时，创建线程时可以创建多个该类的实例。
    ```java
    public void run() {
		  for(int j=0;j<100000;j++){
			   increase();
		    }
	    }
	    public synchronized static void increase(){
		    i++;
	    }
    ```

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 10ReentrantLockTS<br>
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 10ReentrantLockTS2<br>
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 10ReentrantLockTS3<br>
* 普通重入锁和支持中断的重入锁的UML关系
<img width="380" height="300" src="http://www.codenest.cn/static/images/uml/009.jpg"/>

* 重入锁ReentrantLock
    * 重入锁完全可以替代synchronized关键字，两者的执行效率差不多。
    * 与synchronized关键字相比，重入锁支持响应中断，线程发生中断时，它会抛出InterruptedException异常。
    * bool reentrantLock.tryLock(long time,TimeUnit unit)设置重入锁等待超时，一个参数表示等待时长，另一个参数表示时间单位，如果超时返回false，成功获得锁返回true；如果两个参数都不填，尝试获得锁，若获取不到直接返回false，不再进行等待。
    * 公平锁：先申请资源就先获得锁，后申请资源就后获得锁。默认情况下synchronized关键字和重入锁都是`非公平`锁，在创建重入锁时传入true可以创建公平锁。
    ```java
    public static ReentrantLock lock = new ReentrantLock(true);

    ```
* 方法清单
    * void reentrantLock.lock(); //加锁
    * void reentrantLock.lockInterruptibly();//支持中断的加锁
    * void reentraintLock.isHeldByCurrentThread();//判断锁是否被当前线程所拥有
    * bool reentrantLock.tryLock(long time,TimeUnit unit);//设置等待时间
    * bool reentrantLock.tryLock();//尝试获取锁，若获取不到则直接返回false
    * ReentrantLock lock = new ReentrantLock(true);//创建公平锁
    * void reentraintLock.unlock();//释放锁

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 11ConditionTS<br>
* 重入锁条件Condition
    * 通过重入锁的newCondition()方法产生重入锁条件：
    ```java
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();
    ```
    * condition.await()使当前的线程等待，同时会释放与之绑定的重入锁，而当别的线程调用condition.signal()时，condition.await()内部又会等待获取之前与之绑定的重入锁，所以其他线程在调用condition.signal()后一定要释放重入锁。
    
* 方法清单
    * void await() throw InterruptedException; //设置线程等待，若线程发生中断后会抛出InterruptedException
    * void awaitUninterruptibly(); //设置线程等待，但是线程发生中断后不会抛出InterruptedException异常
    * long awaitNanous(long nanosTimeout) throw InterruptedException;//以毫秒为单位设置最长的等待时间
    * boolean await(long time,TimeUnit unit) throw InterruptedException;//设置等待时间，第一个参数是时间值，第二个参数是时间单位
    * boolean awaitUntil(Date deadline) throw InterruptedException;//设置等待结束时间点
    * void signal();//通知等待线程继续执行
    * void signalAll();//通知所有线程继续执行

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 12SemaphoreTS<br>
* 信号量Semaphore
    * 创建信号量对象时指定最大信准入数：
    ```java
    final Semaphore semp = new Semaphore(5);
    ```
     
* 方法清单
    * Semaphore(int permits); //创建信号量对象，指定最大准入数
    * Semaphore(int permits,boolean fair); //创建信号量对象，指定最大准入数和指定是否公平
    * void acquire(); //申请一个信号量准入,可响应线程中断
    * void acquireUninterruptibly();//申请一个信号量准入，但是不可响应线程中断
    * boolean tryAcquire();//申请一个信号量准入，并直接返回
    * boolean boolean tryAcquire(long timeout,TimeUnit unit);//申请一个信号量准入，设置等待时间，第一个参数是时间值，第二个参数是时间单位
    * void release();//释放信号量准入

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 13ReadWriteLockTS<br>
* UML关系
<img width="380" height="300" src="http://www.codenest.cn/static/images/uml/010.jpg"/>

* 读写锁ReentrantReadWriteLock
    * 读写锁的创建过程：
    ```java
    public static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public static Lock readLock = readWriteLock.readLock();
    public static Lock writeLock = readWriteLock.writeLock();
    ```
    * 读与写之间的阻塞关系
        * 读与写发生阻塞
        * 写于写发生阻塞
        * 读余读不发生阻塞
* 方法清单
    * void lock();
    * void unLock();
