
public class MainApp {

	public static void main(String[] args) throws InterruptedException {
		DeamonThread dt = new DeamonThread();
		dt.setDaemon(true);
		dt.start();
		Thread.sleep(2000);
	}

}
