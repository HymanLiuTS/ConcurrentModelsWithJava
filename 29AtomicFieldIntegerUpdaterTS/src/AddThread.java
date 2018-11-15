
public class AddThread implements Runnable {

	@Override
	public void run() {
		if (Math.random() > 0.4) {
			MainApp.scoreUpdate.incrementAndGet(MainApp.candidate);
			MainApp.allScore.incrementAndGet();
		}
	}
}
