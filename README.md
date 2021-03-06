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
* UML类图
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
* UML类图
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
* UML类图
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
* UML类图
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
* UML类图
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
* UML类图
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
* UML类图
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
* UML类图
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
        * 写与写发生阻塞
        * 读与读不发生阻塞
* 方法清单
    * void lock();
    * void unLock();

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 14CountDownLatchTS<br>
* UML序列图
<img width="380" height="300" src="http://www.codenest.cn/static/images/uml/011.jpg"/>

* 倒计时器CountDownLatch
    * CountDownLatch主要用来使线程等待，直到倒计时结束。
    * 创建倒计时器：
    ```java
    CountDownLatch latch = new CountDownLatch(10);
    ```
    * 倒计时器倒计1：
    ```java
    latch.countDown();
    ```
    * 倒计时器等待
    ```java
    latch.await();
    ```
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 15CyclicBarrierTS<br>

* UML类图
<img width="380" height="300" src="http://www.codenest.cn/static/images/uml/012.jpg"/>

* UML序列图
<img width="380" height="300" src="http://www.codenest.cn/static/images/uml/013.jpg"/>

* 循环栅栏CyclicBarrier
    * 创建循环栅栏时会指定计数器数值和计数结束后需要执行的Runnable接口的实现对象，如下创建一个CyclicBarrier，计数器为10，计数结束后执行CyclicBarrierRun对象的run()方法。
    ```java
    CyclicBarrier barrier = new CyclicBarrier(10,new CyclicBarrierRun(flag));
    ```
    * 调用barrier.await()时，调用的线程发生阻塞，并且计数器减1，直到所有的线程调用完了barrier.await()，计数器变成0后线程继续执行。
    * 计数器归零后，还可以重复使用循环栅栏，如下，使用了两次循环栅栏：
    ```java
    @Override
	public void run() {
		try {
			barrier.await();
			dowork();
			barrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
    ```
* 方法清单
    * CyclicBarrier(int parties, Runnable barrierAction);//创建CyclicBarrier对象，指定最大计数器数以及计数器归零后需要执行的Runnable实现对象。
    * void await();//阻塞线程并开始等待CyclicBarrier的计数器归零

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 16LockSupportTS<br>

* UML序列图
 <img width="380" height="300" src="http://www.codenest.cn/static/images/uml/014.jpg"/>

* 线程阻塞工具LockSupport
    * LockSupport调用静态方法park()使当前线程阻塞，调用静态方法unpark(Thread t)使得当前线程阻塞状态。
    * 与thread.suspend()和thread.resume()相比，LockSupport不存在先unpart()，再进行park(）出现的线程死锁的问题。
    * 与object.wait()相比，LockSupport在进行park()时，不需要先获取对象锁，也就是不必须在synchronized语句块里面。
    * 调用LockSupport.park()，线程处于阻塞状态时可以相应线程中断，但是此时park()不会抛出InterruptedException，而是直接返回。

* 方法清单
    * static LockSupport.park();//阻塞当前的线程
    * static LockSupport.parkNanos(long nanos);//阻塞当前的线程并以毫秒为单位设置等待时间
    * static LockSupport.parkUntil(long deadline);//阻塞当前的线程并以unix时间戳设置截至时间
    * static LockSupport.unpark(Thread t);//结束线程t的阻塞状态
 
 ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 17ThreadPoolTS<br>
 ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 18ThreadPoolTS2<br>
 
 * Excutors相关静态关系图
  <img width="380" height="300" src="http://www.codenest.cn/static/images/uml/015.jpg"/>
 
 * 线程池
     * 线程虽然是一个轻量级的工具，但是它也要占用内存空间，大量的线程会抢占宝贵的内存资源。
     * 线程池对线程进行集中管理，使用线程池后创建线程变成从线程池获得空闲线程，关闭线程变成向支持归还线程。
     * 获取线程池服务的五个接口：
         * public static ExecutorService Executors.newFixedThreadPool(int nThreads);//获取含有一个固定含有nThreads个线程的线程池
         * public static ExecutorService Executor.newSingleThreadExecutor();//获取一个只含有一个线程的线程池
         * public static ExecutorService Executor.newCachedThreadPool();//获取一个含有动态数量个线程的线程池
         * public static ScheduledExecutorService Executors.newSingleThreadSchduledExecutor();//获取一个只含有一个线程的计划任务池
         * public static ScheduledExecutorService Executors.newScheduledThreadPool(int nThreads);//获取一个含有动态个数个计划任务的线程池
* 计划任务ScheduledExecutorService
    * 计划任务不同于线程，它可以执行不同的接口，设置不同的执行计划，按照计划永远执行下去（除非遇到了线程中断或者异常）
        * public ScheduledFuture ScheduledExecutorService.schedule(Runnable command,long delay,TimeUnit unit);//设置按照delay延时执行
        * public ScheduledFuture ScheduledExecutorService.sheduleAtFixedRate(Runnable command,long initialDelay,long period,TimeUnit unit);//设置起始延迟initialDelay，然后以开始时间点为基准每period执行一次线程函数
        * public ScheduledFuture scheduleAtFixedDelay(Runnable command,long initialDelay,long delay,TimeUnit unit);//设置起始延迟initialDelay，然后然后以上次任务的结束时间到这次任务的开始时间间隔为delay继续执行

* 线程池的内部实现<br>
　　上述前三种创建线程池的接口中，每一个内部其实都调用了ThreadPoolExexutor的方法，最后都是返回了一个ThreadPoolExecutor对象，其构造函数如下：
  ```java
  public ThreadPoolExecutor(
  int corePoolSize,
  int maximumPoolSize,
  long keepAliveTime,
  TimeUnit unit,
  BlockingQueue<Runnable> workQueue,
  ThreadFactory threadFactory,
  RejectedExecutionHandler handler
  );
  ```
    * corePoolSize： 指定了线程池中线程数量
    * maximumPoolSize：指定了线程中最大线程数量
    * keepAliveTime：当线程数量超过corePoolSize时，多余线程的存活时间
    * unit：指定上述时间的单位
    * workQueue：任务队列
    * threadFactory：线程工程，用来创建线程
    * handler：拒绝策略，当任务太多来不及处理，如何拒绝任务

* 任务队列
    * 直接提交的队列SynchronousQueue<br>
    该队列没有容量，每提交一个任务就会创建一个线程去执行该任务，直到线程数量达到maximumPoolSize时执行拒绝策略。newCachedThreadPool()就是采用的该种任务队列，所以动态的创建线程。
    * 有界的任务队列ArrayBlockQueue(int capacity)<br>
    该队列创建一个有固定大小的任务队列。当有新的任务提交时，如果线程池的实际线程数小于corePoolSize，则创建线程执行任务；如果线程池的实际线程数等于corePoolSize，则将任务放进任务队列。如果任务队列满了之后，则创建新的线程执行任务。
    * 无界的任务队列LinkedBlockingQueue<br>
    该队列创建一个无固定大小的任务队列。当有新的任务提交时，如果线程池的实际线程数小于corePoolSize，则创建线程执行任务；如果线程池的实际线程数等于corePoolSize，则将任务放进任务队列，而且该任务队列永远不会满。ewSingleThreadExecutor()和newFixedThreadPool(int nThreads)创建的都是该类型的队列。
    * 优先任务队列PropertyBlockingQueue<br>
    该队列创建一个有限队列，可以根据任务的优先级顺序先后执行任务。
    
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 19RejectionTS<br>

* UML序列图
 <img width="380" height="300" src="http://www.codenest.cn/static/images/uml/016.jpg"/>
 
* 自定义拒绝策略<br>

    自定义拒绝策略需要实现RejectedExecutionHandler接口，并实现其rejectedExecution方法：
```java
    public class MyRejectedExecutionHandler implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println(r.toString() + " is discard.");
	}

}
```
    
   接下来，我们可以在创建线程池时，将上述对象添加到线程池中：
```java
    	ExecutorService myExecutor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MICROSECONDS,
				new ArrayBlockingQueue<Runnable>(10), Executors.defaultThreadFactory(),
				new MyRejectedExecutionHandler());
```
* 内置的拒绝策略：
    * AbortPolicy策略，该策略直接抛出异常，组织系统正常工作。
    * CallerRunsPolicy策略，只要线程池未关闭，该策略直接在调用者线程中，运行当前被丢弃的任务。
    * DiscardOledesPolicy策略，该策略丢弃最老的一个请求，也就是即将被执行的一个任务。
    * DiscardPolicy策略，该策略丢弃一个任务，不做任何处理。
    
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 20ThreadFactoryTS<br>

* UML类图
 <img width="380" height="300" src="http://www.codenest.cn/static/images/uml/017.jpg"/>
 
 * 自定义线程工程<br>
    自定义线程工厂，需要实现ThreadFactory接口，并实现其newThread(Runnable r)方法，在该方法中可以设置线程的一些属性或者进行其它操作，比如设置线程为守护线程或者打印线程信息等等：
```java
public class MyThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setDaemon(true);
		System.out.println("Create " + t);
		return t;
	}

}
```

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 21ThreadPoolExecutorTS<br>
* UML类图
 <img width="380" height="300" src="http://www.codenest.cn/static/images/uml/018.jpg"/>

* 自定义线程池<br>
    自定义线程池，需要继承ThreadPoolExecutor接口，该接口包含以下三个方法：
    * protected void beforeExecute(Thread,Runnable);//在线程池执行一个任务之前调用
    * protected void afterExecute(Runnable,Throwable);//在线程池执行一个任务之后调用
    * protected void terminated();//线程池shutdown后调用
    
* 示例：
```java
public class MyThreadPoolExecutor extends ThreadPoolExecutor {

	public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		System.out.println("准备执行: "+((MyTask)r).name);
	}

	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		System.out.println("执行完成: "+((MyTask)r).name);
	}
	
	@Override
	protected void terminated(){
		System.out.println("线程池退出");
	}	
}
```

* 方法清单：
    * protected void threadPoolExecutor.beforeExecute(Thread,Runnable);//在线程池执行一个任务之前调用
    * protected void threadPoolExecutor.afterExecute(Runnable,Throwable);//在线程池执行一个任务之后调用
    * protected void threadPoolExecutor.terminated();//线程池shutdown后调用
    * public void executorService.execute(Runnable r);//执行任务r
    * public void executorService.shutdown();//关闭线程池
    
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 22TraceThreadPoolExecutor<br>
* UML类图
 <img width="380" height="300" src="http://www.codenest.cn/static/images/uml/019.jpg"/>
 
* 方法清单
    * threadPoolExecutor.submit(Ruanable task);//提交任务，如果任务产生异常不打印异常信息到调用堆栈
    * threadPoolExecutor.execute(Runnable task);//提交任务，如果任务产生异常打印异常信息到调用堆栈

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 23ForkJoinPoolTS<br>
* UML类图
<img width="380" height="300" src="http://www.codenest.cn/static/images/uml/020.jpg"/>
 
* UML序列图
<img width="380" height="300" src="http://www.codenest.cn/static/images/uml/021.jpg"/>

* 分而治之：Fork/Join框架<br>
    Fork/Join框架主要用来解决处理大量数据的方法，我们可以想ForkJoinPool线程池提交一个ForkJoinTask，该类型的任务支持fork()分解，将大的任务分解的小的子任务进行处理，同时支持join()等待，等待任务结束或者返回数据。ForkJoinTask有两个重要的子类，RecursiveAction和RecursiveTask，分别表示没有返回值的任务和可以携带返回值的任务。

* 方法清单
    * T recursiveTask.compute();//线程池将调用该接口进行相应处理，有返回值
    * void recursiveAction.compute();//无返回值的线程处理函数
    * T recursiveTask.join();//有返回值的线程等待函数
    * void recursiveAction.join();//无返回值的线程等待函数
    * void forkJoinTask/recursiveTask/recursiveAction.fork();//分解任务
    * <T> ForkJoinTask<T> forkJoinPool.submit(ForJoinTask<T> task);//向线程池forkJoinPool中提交任务task
	
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 24BloackingQueueTS<br>
* BlockingQueue<br>
　　共享数据通道BlockingQueue解决多线程开发中数据共享的问题，它类似于小区中的邮箱，实现了数据的存储和读取的分离，它提供了相应的接口，在写入时如果空间已满，则进行等待，直到有空间存储为止；在读取时，如果没有元素，则进行等待，直到有元素可读取为止。
    * BlockingQueue是一个接口，并非一个具体的实现，而其具体的实现有ArrayBlockingQueue和LinkedBlockingQueue等等。
    * blockingQueue.offer()方法，如果当前队列已经满了，立即返回false；如果没有满，执行正常的入队操作。
    * blockingQueue.put()方法，将元素压入队列末尾，如果队列满了，它会一直等待。
    * blockingQueue.poll()方法，它从队列的头部直接获取一个元素，如果队列为空则直接返回null
    * blockingQueue.take()方法，它从队列的头部获取一个元素，如果队列为空则进行等待

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 24ConcurrentHashMapTS<br>
* 线程安全的HashMap
    * 使用Collection.synchronizedMap()对HashMap进行封装：
```java
public static Map smap = Collections.synchronizedMap(new HashMap());
```
    * 使用ConcurrentHashMap
```java
public static Map cmap = new ConcurrentHashMap();
```
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 24ConcurrentLinkedQueueTS<br>

* 高效的读写队列ConcurrentLinkedQueue
    * ConcurrentLinkedQueue是高并发环境中性能最好的队列。

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 24CopyOnWriteArrayListTS<br>

* 高效读取——不变模式下的CopyOnWriteArrayList
    * 读取操作不会加锁，写入也不会阻塞读取操作，只有在写与写之间需要进行同步等待。
    * 在写入操作时，并不会修改原有的内容，而是进行一次自我复制，将修改后的内容写入到副本中，写完之后将修改完的副本替换原来的数据，这样保证写操作不会影响读。

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 24CurrentSkipListMapTS<br>
* 使用跳表SkipList实现的Map
    * 跳表是一种可以快速查找的数据接口，类似于平衡树，但是和平衡树的区别：对平衡树的插入和删除往往很可能导致整个平衡树进行全局的调整，对跳表的插入与删除只需要对整个数据结构的局部进行操作即可。
    * 跳表的本质是同时维护了多个链表，并且链表是分层次的，最底层的链表维护了跳表内的所有元素，每上面一层链表都是下面一层的子集，一个元素插入哪些层完全是随机的。
    * 跳表内所有链表的元素都是排序的，查找时，可以从顶级链表开始找，一旦发现被查找的元素大于当前链表中的取值，就会转入下一层继续寻找。
    * CurrentSkipListMap是使用跳表实现的Map，和HashMap不同，它所有的键值都是排序的。
<img width="380" height="300" src="http://www.codenest.cn/static/images/uml/022.png"/>

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 24VectorTS<br>
* 线程安全的List
    * 使用Collection.synchronizedList()对ArrayList等普通List进行封装：
    * 使用线程安全的Vector  

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 25ThreadLocalTS<br>
* 线程局部变量ThreadLocal
    * ThreadLocal是一个线程局部变量，也就是说只有当前线程可以访问。
    * 创建ThreadLocal对象:
    ```java
    public static final ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<SimpleDateFormat>();
    ```
    * 获取ThreadLocal中封装的对象-threadLocal.get();
    * 将对象封装到ThreadLocal中-threadLocal.set(new SimpleDateFormat());
    * 将对象从ThreadLocal中删除-threadLocal.remove()
* ThreadLocal实现的原理
　　每个线程都有一个ThreadLocalMap的映射，threadLocal.set(new SimpleDateFormat())可以将本线程作为key值，封装的对象作为value存入该map中，这样每个线程都具有这个一个局部对象，互相不能访问，保证线程安全。
  
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 26AtomicIntegerTS<br>

* 比较转换CAS算法<br>
　　CAS算法过程是这样的：它包含三个参数CAS(V,E,N)。V表示要更新的变量，E表示预期的值，N表示新值。仅当v值等于预期值E时才会将V值设为N。
* 无锁的线程安全整数：AtomicInteger
    * AtomicInteger的本质就是一个整数，内部使用了CAS算法保证了线程安全。
    * AtomicInteger主要方法如下：
        * public final int get()   //取得当前值
        * public final void set(int newValue) //设置当前值
        * public final getAndSet(int newValue) //设置新值并返回旧值
        * public final boolean compareAndSet(int expect,int u)  //如果当前值为expect，则设置为u
        * public final int getAndIncrement()  //当前值加1，返回旧值
        * public final int getAndDecrement() //当前值减1，并返回旧值
        * public final int getAndAdd(int delta) //当前值增加Delta，返回旧值
        * public final int incrementAndGet()  //当前值加1，返回新值
        * public final int decrementAndGet()  //当前值减1，返回新值
        * public finale int addAndGet(int delta) //当前值增加delta，返回新值
    * 类似AomicInteger，还有类似的类AtomicLong表示Long、AtomicBoolean表示Boolean和AtomicReference表示对象引用。
    
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) Unsafe类<br>
* Java中的指针：Unsafe类
    * Unsafe类封装了一些指针的操作，它常见的方法如下：
        * public final native boolean compareAndSwapInt(Object o,long offset,int expected,int x);//o是给定的对象，offset是字段到对象头部的偏移量，expected表示期望值，x表示要设置的值。改方法内部利用比较转换算法设置对象o的某个字段。
        * public native int getInt(Object o,long offset); //获取给定对象偏移量上int的值
        * public native void putInt(Object o,long offset,int x); //设置给定对象偏移量上的int的值
        * public native long objectFieldOffset(Field f); //获得字段在对象中的偏移量
    * Unsafe类是一个JDK内部使用的专属类，我们不能进行使用！
    
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 27AtomicStampedReferenceTS<br>
* 带有时间戳的对象引用——AtomicStampedRefereence
    * AtomicStampedRefereence的提出是为了解决下面这种场景：当使用AtomicReference获得对象当前的数据后，在准备修改成为新值前，对象的值被其它线程连续修改了两次，而经过这两次修改后，对象的值又成为了旧值。
    * AtomicStampedRefereence的常用方法：
        * public boolean compareAndSet(V expectedReference,V newReference,int expectedStamp,int new stamp);//比较设置，参数依次是期望值、写入新值、期望时间戳、新时间戳
        * public V getReference(); //获取当前对象引用
        * public int getStamp(); //获取当前时间戳
        * public void set(V newReference,int newStamp); //设置当前对象引用和时间戳
	
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 28AtomicIntegerArray<br>
* 无锁数组AtomicIntegerArray方法列表
    * public final int get(int i); //获取数组第i个下标的元素
    * public final int length(); //获取数组的长度
    * public final int getAndSet(int i,int newValue); //将数组的第i个下标设置为newValue，并返回旧的值
    * public final boolean compareAndSet(int i,int expect,int update); //利用CAS操作更新值，成功返回ture，失败返回false
    * public final int getAndIncrement(int i);//第i个下标的元素加1
    * public final int getAndDecrement(int i);//第i个小标的元素减1
    * public final int getAndAdd(int i,int delta);//将第i个下标的元素增加delta
* 其它无锁数组
    * AtomicLongArray
    * AtomicReferenceArray
    
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 29AtomicFieldIntegerUpdaterTS<br>
* 利用CAS算法更新对象的字段
    * 创建Updater对象：
    ```java
    public final static AtomicIntegerFieldUpdater<Candidate> scoreUpdate = AtomicIntegerFieldUpdater
			.newUpdater(Candidate.class, "score");
    ```
    * 对对象stu的score字段加1并返回最新值
    ```java
    scoreUpdate.incrementAndGet(stu);
    ```
    * Updater只能修改其可见的变量，因为其利用反射得到这个变量。如果变量为private则修改失败。
    * 要修改的变量必须时volatile类型的。
    * 不支持static变量的修改
* 其它updater
    * AtomicFieldLongUpdater
    * AtomicFieldReferenceUpdater

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 30LockFreeVector<br>
使用无锁实现的Vector<br>
<img width="380" height="300" src="http://www.codenest.cn/static/images/uml/023.jpg"/>

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 31StaticSingletonTS<br>
```java
public class StaticSingleton {

	private StaticSingleton() {

	}

	private static class SingletonHolder {
		private static StaticSingleton instance = new StaticSingleton();
	}

	public static StaticSingleton getInstance() {
		return SingletonHolder.instance;
	}

}
```
单例模式：使用上述方法创建的单例模式,巧妙的利用了内部类和类的初始化方式，使得只有在getInstance()方法第一次被调用时StaticSingleton实例才会被创建。

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 32ImmutableTS<br>
```java
public final class Product { // 确保无子类

	private final String no; //私用属性不会被其它对象获取，final关键字保证属性不会二次赋值

	private final String name;

	private final double price;

	public Product(String no, String name, double price) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
	}
	public String getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
}
```
* 不变模式:
    * 不变模式的对象被创建后，其内部状态和数据不再发生任何变化。
    * 不变模式的对象在多线程访问中，所有实例的方法均不需要进行同步操作，从而保证了它的性能。
    * 不变模式的类应该包含可以创建完整对象的构造函数。
    * 不变模式的类通过使用final关键字，从而保证没有子类可以继承它并重载它行为。
    * 不变模式的类去除了setter以及所有可以修改自身属性的方法。
    * JDK中String、Boolean、Double等类都使用了不变模式，以String类为例，其不变模式的含义是其内部用来存放字符的数组引用位置不变，并不是指数组中内容不变；而对于同一个字符串"hello world"，不同的变量都赋予该值时，实际上所有的变量都指向了改字符串在内存中的位置，从而提高了性能。
    * 不变模式唯一的缺点是：一旦需要修改一个不变对象的状态，就只好创建一个新的同类对象。在需要频繁修改不变对象的环境里，会有大量的不变对象作为中间结果被创建出来，再被JAVA垃圾收集器收集走。这是一种资源上的浪费。
    
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 33ProducerAndConsumeTS<br>
生产者消费者模式类图：<br>
<img width="380" height="300" src="http://www.codenest.cn/static/images/uml/024.jpg"/>

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 34DisruptorTS<br>

* Disruptor使用模型静态图

<img width="380" height="300" src="http://www.codenest.cn/static/images/uml/025.jpg"/>

* 无锁的缓存框架Disruptor
    * Disruptor使用无锁的方式实现了一个环形队列，每一个Disruptor对象都有这样一个队列。
    * Disruptor环形队列的大小必须提前指定，不能动态扩展，并要求将该队列的大小设置为2的整数次方。
    * 创建Disruptor对象的方法：<br>
    ```java
    Executor executor = Executors.newCachedThreadPool();
		PCDataFactory factory = new PCDataFactory();
		int bufferSize = 1024;
		Disruptor<PCData> disruptor = new Disruptor<PCData>(factory, bufferSize, executor, ProducerType.MULTI,
				new BlockingWaitStrategy());
    
    ```
        
        
        * factory -- 用来创建环形队列存储单位的工厂,工厂类需要实现EventFactory接口
        * executor -- 线程池，用来创建消费者的处理线程
        * bufferSize -- 环形队列初始大小
        * BlockingWaitStrategy -- 等待策略
    * 提交消费者的方法：
```java
disruptor.handleEventsWithWorkerPool(new Consumer(), new Consumer(), new Consumer(), new Consumer());
disruptor.start();
```
　　消费者必须实现WorkHandler接口，该接口有一个onEvent方法，为消费者处理数据的回调方法：
```java
public class Consumer implements WorkHandler<PCData> {

	public void onEvent(PCData event) throws Exception {
		System.out.println(Thread.currentThread().getId() + ":Event:--" + event.getValue() * event.getValue() + "--");

	}

}

```

    * 创建生产者的方法：
    
```java
RingBuffer<PCData> ringBuffer = disruptor.getRingBuffer();
Producer producer = new Producer(ringBuffer);
```
　　对生产者没有接口上的要求，但是需要有一个环形变量RingBuffer成员，通过依赖注入的方式创建。<br>
    
    * 等待策略
        
        * BlockingWaitStrategy -- 默认策略，使用锁和条件进行数据的监控和线程的唤醒。因为涉及到线程的切换，该策略最节省CPU，但是在高并发下性能表现最糟糕的。
        * SleepingWaitStrategy -- 它先进行自旋等待，如果不成功，则使用Thread.yield()让出CPU，并最终使用LockSupport.parkNanos(1)进行线程休眠，该策略对于数据处理会产生比较高的平均延时，适合对延时要求不是很高的场合。
        * YieldingWaitStrategy -- 消费者线程会不断的循环监控缓冲区变化，在循环内部它会使用Thread.yield()，让出CPU给别的线程，该策略适合于低延时的场合。
        * BusySpinWaitStrategy -- 它就是一个死循环，消费者线程会尽最大的努力监控缓冲区的变化，它会吃掉CPU的资源，只有在延时要求非常苛刻的场合下使用。
  
* 伪共享
    * 什么是伪共享问题呢<br>
　　我们知道为了提高CPU的速度CPU有一个高速缓存cache，在高速缓存中，读写数据的最小单位是缓存行，它是从内存复制到缓存cache中的最小单位，一般为32到128字节。如果两个变量在同一个缓存行中，在多线程访问时，一个线程所在的CPU修改了其中一个变量，就会造成另外一个线程所在的CPU缓存行无效，就要重新载入缓存行，这就造成了性能上的问题，这就是伪共享问题。如下所示：
  
<img width="380" height="300" src="http://www.codenest.cn/static/images/uml/026.jpg"/>

* Disruptor的解决方案<br>
　　解决伪共享问题一个根本性的思路就是使变量X和Y各占一个缓存行，在Disruptor中，其核心组件Sequence被频繁访问，它采用类似下面的方法，将一个Sequence对象设置成占有一个缓存行，其核心的数据是value，其它的字段都是为了占用一个缓存行而进行的填充：
```java
public final static class VolatileLong{
    public volatile long value = 0L;
    public long p1,p2,p3,p4,p5,p6,p7;
}
```

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 35FutureTS<br>
* Future模式<br>
　　我们在调用某方法时，有时候并不急着要结果，因此我们可以让被调用者立即返回，让它在后台慢慢处理这个请求，对于调用者来说，则可以先处理一些其它任务，这就是Future模式。
  
* Future模式序列图
<img width="380" height="300" src="http://www.codenest.cn/static/images/uml/028.jpg"/>

* Future模式静态图
<img width="380" height="300" src="http://www.codenest.cn/static/images/uml/027.jpg"/>

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 36JDKFutureTS<br>
* JDK中的Future模式
　　使用JDK的Future模式时，构造的真实数据必须继承Callable接口，该接口有一个call()方法，该方法会构造我们需要的真实数据并返回：
```java
public class RealData implements Callable<String> {
	private String para;
	public RealData(String para) {
		this.para = para;
	}
	@Override
	public String call() throws Exception {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			sb.append(para);
			Thread.sleep(100);
		}
		return sb.toString();
	}
}
```
　　FutureTask的构造函数需要传入Callable的实现，也就是我们定义的真实数据RealData对象，使用线程池时传入我们创建的FutureTask，再通过该FutureTask对象获取RealData对象call方法返回的结果。
```java
FutureTask<String> future = new FutureTask<String>(new RealData("a"));
ExecutorService executor = Executors.newFixedThreadPool(1);
executor.submit(future);
```

　　FutureTask的可用接口：<br>
 1、V futureTask.get(); //获取RealData中call()的返回结果。<br>
 2、boolean cancle(boolean mayInterruptIfRunning);//取消任务<br>
 3、boolean isCancled();//是否已经取消任务<br>
 4、boolean isDone();//是否已经完成<br>
 5、V get(long timeout,TimeUnit unit);//获取RealData中call()的返回结果,可以设置超时时间<br>

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 37JDKFutureTS<br>

* 并行流水线技术<br>
　　并行流水线技术类似于批量地生产某产品，在本例子中利用并行流水线模型批量处理(A+B)*A/2，主函数将A和B组成的Msg对象放入到加法计算线程的队列中，然后进行(A+B)的计算，计算完成后的结果存入到乘法计算的队列中，然后完成乘法计算之后，又将结果放入到除法计算的队列中，最后得到最终的结果并打印。

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 38ParallelSerachTS<br>
* 并行搜索技术<br>
　　并行搜索技术的实现原理，是先将搜索的数组进行分段，用一个原子量AtomicInteger对象存储获取到的目标值的索引，其初始值为-1，一旦又线程找到目标值就会将其设置成非负值，也就找到了目标。

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 39OddEvenSortTS<br>
* 并行奇偶排序模型
    * 排序时，先进行数组奇数位置的元素排序，每个元素和其后一个位置的元素比较并交换；然后再进行偶数位置的元素的排序；
    * 奇偶之间的排序具有先后顺序，但是单次奇排序或者单次偶排序时，各个位置之间相互不影响，可以分多个线程执行比较排序操作；
    * 利用倒计时器，主线程等等，每次比较创建一个线程，执行完成后倒计时器减1，直到倒计时器变成0；

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 40ShellSortTS<br>
* 并行希尔排序模型
    * 希尔排序的原型是插入排序，插入排序的原理是从数组的第二个元素a开始，依次和前一个元素b比较，一旦发现该b元素比a大，b元素们依次向后依次挪一位，直到找到比a元素小的元素为止。因为是从第二个元素开始排序的，所以a元素的左边永远是拍好序的。
    * 希尔排序是插入排序的拓展版本，它将待排序数组分成h份，每次排序时，分别排序0，0+h,0+2h...;1,1+h,1+2h...;h-1,h-1+h,h-1+2h...;位置上的元素。h是个循环变量，范围可从数组长度或者指定长度到1，当h=1时相当于依次插入排序。
    * 并行的希尔排序相当于将上述比较的过程放到了子线程中，并行的希尔排序效率比并行的奇偶排序高很多。
    
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 43NIOEchoServer<br>
* NIO(New IO)<br>
    * 使用NIO相对于传统的IO，可以将网络IO的等待时间从业务处理线程种抽取出来，在NIO中有一个关键组件Channel，一个Channel可以和文件或者网络Socket对应，网这个Channel中写数据，就相当于向文件或者Socket中写数据。
    * NIO的使用模型如下：<br>
    <img width="380" height="300" src="http://www.codenest.cn/static/images/uml/029.jpg"/>
　　从上面的模型图中我们看到，另外几个重要的组件Selector（选择器）、SelectionKey。每个Channel都可以把自己注册进一个Selector，并产生一个SelectionKey对象。Selector负责管理各个Channel，它的selectedKeys()方法可以获取到所有发生了IO事件的SelectionKey集合，遍历这个集合，并通过SelectionKey可以判断是发生了何种类型的IO事件，是Accept、Read、Write？然后通过该SelectionKey获取到相应的channel，进行相应的IO操作。<br>
```NIO类图```<br>
     <img width="380" height="300" src="http://www.codenest.cn/static/images/uml/030.jpg"/>

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 44AIOEchoServer<br>
* 异步IO（Asynchronous IO）
    * 异步IO通过异步通道AsynchronousServerSocketChannel和AsynchronousSocketChannel实现IO操作。
    * AsynchronousServerSocketChannel和AsynchronousSocketChannel的accept、connect、write、read函数都是异步的，函数的最后一个参数是定义的一个回调函数类型CompletionHandler，当完成上述IO操作时就会调用该回调函数类型对象。
    * write、read函数返回值为Future类型，直接返回后，可以调用futrue.get()获取返回结果，此时线程会阻塞。
    * 异步IO的方法清单如下：
        * public static AsynchronousSocketChannel open()//打开异步IO对象
        * public final AsynchronousServerSocketChannel bind(SocketAddress local)//绑定IP地址
        *  public abstract <A> void accept(A attachment,CompletionHandler<AsynchronousSocketChannel,? super A> handler)//接受客户端连接并定义回调函数对象
        * public abstract <A> void connect(SocketAddress remote,A attachment,CompletionHandler<Void,? super A> handler)//连接服务端并定义回调函数对象
        * public final <A> void read(ByteBuffer dst,A attachment,CompletionHandler<Integer,? super A> handler)//读取IO数据并定义回调函数对象
        * public final <A> void write(ByteBuffer src,A attachment,CompletionHandler<Integer,? super A> handler)//写入IO数据并定义回调函数对象
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 45ParalStreamTS<br>  
* Arrays的并行操作<br>
在java8之后Arrays提供了许多并行方式的操作，犹如排序或者赋值，保证我们在使用时可以利用并行，最大限度的提高性能：
```java
	public static void main(String[] args) {
		int[] arr=new int[10000];
		Arrays.parallelSort(arr);//并行排序
		Random random=new Random();
		Arrays.parallelSetAll(arr, (i)->i=random.nextInt());//并行赋值
	}
```
* 流Stream的并行<br>
我们也可以对Stream相关操作进行并行，只需调用其parallel()方法即可，如下演示了在普通模式和并行模式下进行数据过滤的方法：
```java
public class PrimeUtil {

	public static boolean isPrime(int number) {
		int tmp = number;
		if (tmp < 2)
			return false;
		for (int i = 2; Math.sqrt(tmp) >= i; i++) {
			if (tmp % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(IntStream.range(1, 10000).filter(PrimeUtil::isPrime).count());//´®ÐÐÁ÷
		System.out.println(IntStream.range(1, 10000).parallel().filter(PrimeUtil::isPrime).count());//²¢ÐÐÁ÷
	}

}
```
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 46CompeletableFutureTS<br>
　　CompeletableFuture是一种增强的Future模式工具，它在java8中被提供出来，主要用来实现java8中函数式编程的流式调用。
* 普通future模式的功能
```java
public class AskThread implements Runnable {

	CompletableFuture<Integer> re = null;

	public AskThread(CompletableFuture<Integer> re) {
		this.re = re;
	}

	@Override
	public void run() {
		int myRe = 0;
		try {
			myRe = re.get() * re.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(myRe);
	}

	public static void main(String[] args) throws InterruptedException {
		final CompletableFuture<Integer> future = new CompletableFuture<>();
		new Thread(new AskThread(future)).start();
		Thread.sleep(1000);
		future.complete(60);
	}

}
```
　　主函数中模拟长时间的计算过程，其中future.complete(60)的意思是已经计算完成并且通知计算结果60，这里和传统的future模式的区别就是，我们可以手动的改变future的状态，调用comlele()之后，表示工作完成。
  
* 异步执行任务<br>
　　CompeletableFuture提供了异步的函数可以异步执行任务，函数的参数为一个静态方法：
```java
public static Integer calc(Integer para) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		return para * para;
	}

public static void main(String[] args) throws InterruptedException, ExecutionException {
		final CompletableFuture<Integer> future=CompletableFuture.supplyAsync(()->calc(50));
		System.out.println(future.get());
	}
```
　　除了以上代码中的CompletableFuture.supplyAsync之外，CompletableFuture还包含其它的异步方法：<br>
　　（1）static <U> CompeletableFuture<U> supplyAsync(Supplier<U> supplier);<br>
　　（2）static <U> CompeletableFuture<U> supplyAsync(Supplier<U> supplier,Executor executor);<br>
　　（3）static <U> CompeletableFuture<U> runAsync(Supplier<U> supplier);<br>
　　（4）static <U> CompeletableFuture<U> runAsync(Supplier<U> supplier,Executor executor);<br>
　　方法中我们可以指定执行异步操作的线程池executor，如果不指定则在默认的ForkJoinPool.common中执行；supplyAsync和runAsync分别表示作为参数的函数带返回值或者不带返回值。

* 流式调用<br>
　　CompeletableFuture实现了了CompeletableStage接口，可以实现流式调用：
 ```java
 CompletableFuture<Object> fu=CompletableFuture.supplyAsync(()->calc(50))
				.thenApply(x->Integer.toString(x))
				.thenApply((str)->"\""+str+"\"");
		System.out.println(fu.get());
 ```
* 异常处理<br>
　　CompeletableFuture的异常处理可以直接在流式调用语句中进行
```java
 CompletableFuture<Object> fu=CompletableFuture.supplyAsync(()->calc(50))
				.exceptionally(ex->{System.out.println(ex);return 0;})
				.thenApply(x->Integer.toString(x))
				.thenApply((str)->"\""+str+"\"");
		System.out.println(fu.get());
```
* 组合多个CompletableFuture<br>
　　可以使用thenCompose方法将两个CompletableFuture组合在一起，前一个CompletableFuture的返回结果将作为后一个的函数的参数：
```java
CompletableFuture<Object> fu=CompletableFuture.supplyAsync(()->calc(50))
				.thenCompose((i)->CompletableFuture.supplyAsync(()->calc2(i)));
		System.out.println(fu.get());
```
　　也可以使用thenCombine将两个CompletableFuture的结果作为参数传给第三个CompletableFuture：
```java
CompletableFuture<Integer> fu1=CompletableFuture.supplyAsync(()->calc(50));
CompletableFuture<Integer> fu2=CompletableFuture.supplyAsync(()->calc(25));
fu=fu1.thenCombine(fu2, (x,y) -> (x+y));
System.out.println(fu.get());
```
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 47StampLockTS<br>
* StampedLock<br>
　　StampedLock是读写锁的改进版，它也有读锁readLock和写锁writeLock，readLock和readLock之间可以完全并发，readLock也会阻塞writeLock，这点和读写锁是一样的，但是它有一种乐观读锁模式tryOpiimisticRaed,在使用读出来的数据之前可以通过方法validate来判断读出来的值是否有效，如果无效，可以采用类似读写锁的那种悲观模式，利用readLock再次读取，并阻塞写线程，也可以利用乐观模式采用一个死循环，不断尝试乐观读。<br>
　　下面的方法，采用写锁进行数据的修改：
```java
	private double x, y;
	private final StampedLock sl = new StampedLock();

	void move(double deltaX, double deltaY) {
		long stamp = this.sl.writeLock();
		try {
			x += deltaX;
			y += deltaY;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.sl.unlockWrite(stamp);
		}
	}
```
　　接下来，在读锁时，我们采用传统的读写锁方式处理读过程：
```java
double distanceFromOrigin() {
		long stamp = this.sl.tryOptimisticRead();
		double currentX = x, currentY = y;
		if (!sl.validate(stamp)) {
			stamp = sl.readLock();
			try {
				currentX = x;
				currentY = y;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				sl.unlockRead(stamp);
			}
		}
		return Math.sqrt(currentX * currentX + currentY * currentY);
	}

```
　　或者通过乐观锁的方式去处理：
```java
		double distanceFromOrigin() {
		long stamp = this.sl.tryOptimisticRead();
		double currentX = x, currentY = y;
		while(!sl.validate(stamp)) {
			stamp = this.sl.tryOptimisticRead();
		}
		currentX = x;
		currentY = y;
		return Math.sqrt(currentX * currentX + currentY * currentY);
	}

```
* StampedLock实现原理<br>
　　StampedLock内部维护着一个等待线程的队列，所有申请锁需要等待的线程都被放入该队列中，因此线程间申请锁的顺序是先进先出。所有线程都在自旋等待，等待条件是前一个队列元素是否释放锁，若已经释放则停止等待，继续执行线程；若没有释放，则继续等待。内部等待采用park()使线程阻塞，因此当线程发生中断时，park()返回，会导致线程继续执行而此时前一个元素还在持有锁的话，会造成本线程的死循环，CUP占有率会飙升。

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 48LongAddrTS<br>
* LongAdder
　　LongAdder相对于普通Long类型和采用CAS算法实现的AtomicLong来说，在并行时会更快，主要得益于它的实现机制：LongAdder在所有的数据都记录在一个称为base的变量中，如果在多线程的条件下，大家修改base没有冲突。但是一旦修改base发生冲突，就会初始化cell数组，将变量分离成多个cell，每个cell独自维护内部的值。如果某个cell上更新依然发生冲突，系统还会尝试创建新的cell。
```java
private LongAdder laccount = new LongAdder();
laccount.increment();//自增1
v = laccount.sum();//获取值
```
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 49LongAccumulatorTS<br>
* 49LongAccumulator<br>
　　LongAccumulator内部的优化方式和LongAdder类似，都是将一个long型整数进行分割，存在不同的变量中，以防止多线程竞争。LongAccumulator更可以实现任意函数操作,如下创建LongAccumulator，传入max函数，而LongAccumulator的第二个参数是初始值。accumulator.accumulate(value)是将数值value传入到LongAccumulator，LongAccumulator会通过max识别最大值，并保存在内部（很可能是cell数组内，也可能是base）。
  
```java
public static long max(long i, long j) {
	return i > j ? i : j;
}

public static void main(String[] args) throws InterruptedException {
	LongAccumulator accumulator = new LongAccumulator(LongAccumulatorTS::max, Long.MIN_VALUE);
	Thread[] ts = new Thread[1000];
	for (int i = 0; i < 1000; i++) {
		ts[i] = new Thread(() -> {
			Random random = new Random();
			long value = random.nextLong();
			accumulator.accumulate(value);
		});
		ts[i].start();
	}
	for (int i = 0; i < 1000; i++) {
		ts[i].join();
	}
	System.out.println(accumulator.longValue());
}
```




















