import java.util.concurrent.atomic.AtomicIntegerArray;

public class MainApp {

	public static AtomicIntegerArray array = new AtomicIntegerArray(10);

	public static void main(String[] args) throws InterruptedException {
		Thread[] ts = new Thread[10];
		for (int k = 0; k < 10; k++) {
			ts[k] = new Thread(new AddThread());
		}

		for (int k = 0; k < 10; k++) {
			ts[k].start();
		}
		for (int k = 0; k < 10; k++) {
			ts[k].join();
		}
		System.out.println(array);
	}

}
