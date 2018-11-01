import java.util.concurrent.locks.LockSupport;

public class MainApp {

	public static void main(String[] args) throws InterruptedException {
		DemoThread t1 = new DemoThread("t1");
		DemoThread t2 = new DemoThread("t2");
		t1.start();
		t2.start();
		LockSupport.unpark(t1);
		LockSupport.unpark(t2);
		Thread.sleep(500);
	}

}
