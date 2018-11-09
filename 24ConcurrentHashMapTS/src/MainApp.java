import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApp {
	public static void main(String[] args) throws InterruptedException {
		long t1 = System.currentTimeMillis();
		System.out.println("SynchronizedMapTS ��ʼ��" + t1);
		for (int i = 0; i < 100000; i++) {
			Thread t=new Thread(new SynchronizedMapTS(i));
			t.start();
			t.join();
		}
		System.out.println("SynchronizedMapTS ��ʱ��" + (System.currentTimeMillis() - t1));
		
		t1 = System.currentTimeMillis();
		System.out.println("ConcurrentHashMapTS ��ʼ��" + t1);
		for (int i = 0; i < 100000; i++) {
			Thread t=new Thread(new ConcurrentHashMapTS(i));
			t.start();
			t.join();
		}
		System.out.println("ConcurrentHashMapTS ��ʱ��" + (System.currentTimeMillis() - t1));
	}
}
