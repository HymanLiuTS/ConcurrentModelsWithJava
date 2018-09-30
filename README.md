# Java并发程序模型

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 01MultiThreadTS<br>
* 创建线程的两种方式：
  * 继承Thread类。
  * 实现Runnable接口。<br>
UML图：
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
* 接口清单
1. void ThreadChild.run();        
2. void Thread.sleep(long millis) throws InterruptedException;
3. Thread Thread.currentThread();  //获取当前线程对象
4. Thread.interrupt();//实例方法，中断线程
5. boolean Thread.isInterrupted(); //实例方法判断线程是否中断
6. static boolean Thread.interrupted();//静态方法，判断线程是否中断并清除中断状态
7. void Thread.stop(); //终止线程，不建议使用
