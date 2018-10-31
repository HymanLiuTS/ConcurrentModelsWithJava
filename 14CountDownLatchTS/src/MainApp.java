import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApp {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec=Executors.newFixedThreadPool(10);
		CountDownLatchRun run = new CountDownLatchRun();
		for(int i=0;i<10;i++){
			exec.submit(run);
		}
		CountDownLatchRun.latch.await();
		System.out.println("Begin!");
		exec.shutdown();
	}

}
