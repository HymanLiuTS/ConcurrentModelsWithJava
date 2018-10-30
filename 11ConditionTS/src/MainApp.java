
public class MainApp {

	public static void main(String[] args) throws InterruptedException {
		ConditionRun run = new ConditionRun();
		Thread t = new Thread(run);
		t.start();
		Thread.sleep(2000);
		ConditionRun.lock.lock();
		ConditionRun.condition.signal();
		ConditionRun.lock.unlock();
	}

}
