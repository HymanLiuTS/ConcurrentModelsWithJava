import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {

	BlockingQueue<PCData> queue;
	private static AtomicInteger count = new AtomicInteger();

	public Producer(BlockingQueue<PCData> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		Random r = new Random();
		System.out.println("start procedur id=" + Thread.currentThread().getId());
		while (true) {
			try {
				Thread.sleep(r.nextInt(10000));
				PCData data = new PCData(count.incrementAndGet());
				System.out.println(data + " is put into the queue");
				if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
					System.out.println("failed to put data: " + data);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
