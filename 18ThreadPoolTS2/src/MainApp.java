import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainApp {

	public static void main(String[] args) {
		MyTask mt = new MyTask();
		//创建只含有一个ScheduledExecutor对象线程池
		//ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		//创建含有固定个数的ScheduledExecutor对象的线程池
		ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
		System.out.println(System.currentTimeMillis()/1000 + ":Thread ID:" + Thread.currentThread().getId());
		for (int i = 0; i < 1; i++) {
			//延迟两秒中执行
			//service.schedule(mt, 2, TimeUnit.SECONDS);
			//起始延迟两秒，然后以开始时间点为基准每1秒执行一次线程函数
			//service.scheduleAtFixedRate(mt, 2, 1, TimeUnit.SECONDS);
			//起始延迟两秒，然后以上次任务的结束时间到这次任务的开始时间间隔为1秒继续执行
			service.scheduleWithFixedDelay(mt, 2, 1, TimeUnit.SECONDS);
		}

	}

}
