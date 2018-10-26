
public class HighPriorityThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 1000000; i++) {
			synchronized (MainApp.lock) {
				
			}
		}
		System.out.println("HighPriorityThread Compele!");
	}

}
