
public class ReenterLock implements Runnable {

	@Override
	public void run() {
		for (int j = 0; j < 1000000; j++) {
			MainApp.lock.lock();
			MainApp.i++;
			MainApp.lock.unlock();
		}
	}
}
