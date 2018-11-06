import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class MainApp {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService es = new MyThreadPoolExecutor(5, 5, 0L, TimeUnit.MICROSECONDS,
				new LinkedBlockingQueue<Runnable>());

		for (int i = 0; i < 5; i++) {
			MyTask mt = new MyTask("TASK-GEYM-" + i);
			es.execute(mt);
			Thread.sleep(10);
		}
		es.shutdown();
	}

}
