import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchRun implements Runnable {

	public static CountDownLatch latch = new CountDownLatch(10);
	

	@Override
	public void run() {
		try {
			Thread.sleep(new Random().nextInt(10) * 1000);
			System.out.println("check complete!");
			latch.countDown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
