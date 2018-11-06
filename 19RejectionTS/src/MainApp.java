import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainApp {

	public static void main(String[] args) throws InterruptedException {
		MyTask myTask = new MyTask();
		ExecutorService myExecutor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MICROSECONDS,
				new ArrayBlockingQueue<Runnable>(10), Executors.defaultThreadFactory(),
				new MyRejectedExecutionHandler());

		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			myExecutor.submit(myTask);
			Thread.sleep(10);
		}
	}
}
