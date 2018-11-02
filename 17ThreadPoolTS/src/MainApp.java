import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApp {

	public static void main(String[] args) {
		MyTask mt = new MyTask();
		//创建一个含有固定线程数量的线程池
		//ExecutorService service = Executors.newFixedThreadPool(5);
		//创建一个只含有一个线程的线程池
		//ExecutorService service = Executors.newSingleThreadExecutor();
		//创建一个含有动态数量线程的线程池
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			service.submit(mt);
		}
		
	}
}
