
public class MainApp {

	public static void main(String[] args) throws InterruptedException {
		new ReaderThread().start();
		Thread.sleep(1000);
		ReaderThread.number = 42;
		ReaderThread.ready = true;
		Thread.sleep(10000);
	}

}
