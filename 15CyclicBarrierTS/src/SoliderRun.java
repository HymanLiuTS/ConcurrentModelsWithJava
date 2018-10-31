import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class SoliderRun implements Runnable {

	private String name;
	private CyclicBarrier barrier;

	public SoliderRun(String name, CyclicBarrier barrier) {
		this.name = name;
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try {
			barrier.await();
			dowork();
			barrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void dowork() throws InterruptedException {
		Thread.sleep(new Random().nextInt(10)*1000);
		System.out.println(name + " work done!");
	}

}
