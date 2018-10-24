
public class NotifyClass extends Thread {

	@Override
	public void run() {
		synchronized (MainClass.lockObj) {
			try {
				System.out.println(System.currentTimeMillis() + "NotifyClass start and notify one object!");
				MainClass.lockObj.notify();
				System.out.println(System.currentTimeMillis() + "NotifyClass end!");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
