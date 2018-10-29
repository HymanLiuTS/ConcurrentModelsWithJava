
public class InterruptReenterLock implements Runnable {

	@Override
	public void run() {
		for (int j = 0; j < 1000000; j++) {
			try {
				MainApp.lock.lockInterruptibly(); 
				MainApp.i++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				if (MainApp.lock.isHeldByCurrentThread()) {
					MainApp.lock.unlock();
				}
			}
		}

	}

}
