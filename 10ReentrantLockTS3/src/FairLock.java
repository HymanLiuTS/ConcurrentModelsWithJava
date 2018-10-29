import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class FairLock implements Runnable {

	public static ReentrantLock lock = new ReentrantLock(true);

	@Override
	public void run() {
		while(true){
			try {
				lock.lock();
				System.out.println(Thread.currentThread().getName()+" �������");
			} finally {
				if (lock.isHeldByCurrentThread()) {
					lock.unlock();
				}
			}
		}
	}
}
