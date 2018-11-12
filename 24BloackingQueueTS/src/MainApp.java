import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApp {

	public static ArrayBlockingQueue queue = new ArrayBlockingQueue(10);

	public static void main(String[] args) {
		ExecutorService es = Executors.newCachedThreadPool();
		for (int i = 0; i < 20; i++) {
			es.submit(new WriteRun(i));
		}
		for (int i = 0; i < 12; i++) {
			es.submit(new ReadRun());
		}
		
	}

}
