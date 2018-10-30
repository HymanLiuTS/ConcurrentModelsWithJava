import java.util.concurrent.Semaphore;

public class SemaphoreRun implements Runnable {

	final Semaphore semp = new Semaphore(5);

	@Override
	public void run() {
		try {
			semp.acquire();
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getId() + ":done!");
			semp.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
