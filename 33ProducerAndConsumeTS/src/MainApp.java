import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class MainApp {

	public static void main(String[] args) {
		BlockingQueue<PCData> queue = new LinkedBlockingQueue<PCData>(10);
		Producer dure1 = new Producer(queue);
		Producer dure2 = new Producer(queue);
		Producer dure3 = new Producer(queue);
		Consumer sumer1 = new Consumer(queue);
		Consumer sumer2 = new Consumer(queue);
		Consumer sumer3 = new Consumer(queue);
		
		ExecutorService service=Executors.newCachedThreadPool();
		
		service.execute(dure1);
		service.execute(dure2);
		service.execute(dure3);
		service.execute(sumer1);
		service.execute(sumer2);
		service.execute(sumer3);
	}

}
