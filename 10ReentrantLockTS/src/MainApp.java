import java.util.concurrent.locks.ReentrantLock;

public class MainApp {

	public static int i = 0;
	public static ReentrantLock lock=new ReentrantLock();

	public static void main(String[] args) throws InterruptedException {
		ReenterLock rl = new ReenterLock();
		Thread t1 = new Thread(rl);
		Thread t2 = new Thread(rl);
		t1.start();t1.join();
		t2.start();t2.join();
		System.out.println(MainApp.i);
		
		InterruptReenterLock irl = new InterruptReenterLock();
		t1 = new Thread(irl);
		t2 = new Thread(irl);
		t1.start();t1.join();
		t2.start();t2.join();
		System.out.println(MainApp.i);
	}

}
