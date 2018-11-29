import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Consumer implements Runnable {

	BlockingQueue<PCData> queue;

	public Consumer(BlockingQueue<PCData> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		Random r = new Random();
		System.out.println("start Consumer id=" + Thread.currentThread().getId());
		while (true) {
			try {
				PCData data = queue.take();
				int d=data.getIntData();
				if (data != null) {
					System.out.println(MessageFormat.format("{0}*{1}={2}", d,d,d*d));
					Thread.sleep(r.nextInt(10000));
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
