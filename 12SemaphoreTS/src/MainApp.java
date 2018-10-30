import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApp {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(20);
		SemaphoreRun run = new SemaphoreRun();
		for (int i = 0; i < 20; i++) {
			service.submit(run);
		}
	}

}
