
public class MainApp {

	public static Object lock = new Object();

	public static void main(String[] args) {
		LowPriorityThread lt = new LowPriorityThread();
		HighPriorityThread ht = new HighPriorityThread();

		lt.setPriority(1);
		ht.setPriority(10);

		lt.start();
		ht.start();

	}

}
