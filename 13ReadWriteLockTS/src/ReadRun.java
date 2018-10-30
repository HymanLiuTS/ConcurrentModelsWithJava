
public class ReadRun implements Runnable {

	@Override
	public void run() {
		try {
			MainApp.demo.handleRead(MainApp.demo.readLock);
			System.out.println("value= " + MainApp.demo.value);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
