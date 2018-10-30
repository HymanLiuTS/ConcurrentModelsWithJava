import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
	public static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	public static Lock readLock = readWriteLock.readLock();
	public static Lock writeLock = readWriteLock.writeLock();
	public static int value;

	public Object handleRead(Lock lock) throws InterruptedException {
		try {
			lock.lock();
			Thread.sleep(5000);
			return value;
		} finally {
			lock.unlock();
		}
	}

	public void handleWrite(Lock lock, int index) throws InterruptedException {
		try {
			lock.lock();
			Thread.sleep(1000);
			value = index;
		} finally {
			lock.unlock();
		}
	}
}
