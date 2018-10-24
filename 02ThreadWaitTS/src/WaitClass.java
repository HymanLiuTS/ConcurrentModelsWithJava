
public class WaitClass extends Thread {

	@Override
	public void run() {
		synchronized (MainClass.lockObj) {
			try {
				System.out.println(System.currentTimeMillis() + "WaitClass start!");
				System.out.println(System.currentTimeMillis() + "WaitClass begin wait!");
				MainClass.lockObj.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(System.currentTimeMillis() + "WaitClass end!");
	}
}
