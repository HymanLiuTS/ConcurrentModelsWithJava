import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
