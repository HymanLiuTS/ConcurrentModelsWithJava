
public class ReadRun implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
			System.out.println("����Ԫ��" + MainApp.queue.take());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
