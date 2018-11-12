
public class WriteRun implements Runnable {

	private int value;

	public WriteRun(int value) {
		this.value = value;
	}

	@Override
	public void run() {
		try {
			MainApp.queue.put(value);
			System.out.println("≤Â»Î‘™Àÿ" + value);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
