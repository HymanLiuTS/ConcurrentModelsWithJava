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
* 继承关系
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
