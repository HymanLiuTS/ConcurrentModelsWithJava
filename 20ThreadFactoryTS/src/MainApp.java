import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainApp {

	public static void main(String[] args) throws InterruptedException {
		MyTask myTask = new MyTask();
		ExecutorService myExecutor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MICROSECONDS,
				new SynchronousQueue<Runnable>(), new MyThreadFactory());
		for (int i = 0; i < 5; i++) {
			myExecutor.submit(myTask);
		}
		Thread.sleep(2000);
	}
}
