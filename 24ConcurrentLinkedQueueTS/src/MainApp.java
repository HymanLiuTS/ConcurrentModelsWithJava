import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApp {

	public static ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();

	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(5);
		es.submit(new WriteRun());
		es.submit(new ReadRun());
	}
}
