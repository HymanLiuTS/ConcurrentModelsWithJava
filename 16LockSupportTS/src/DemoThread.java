import java.util.concurrent.locks.LockSupport;

public class DemoThread extends Thread {

	public DemoThread(String name) {
		this.setName(name);
	}

	@Override
	public void run() {
		System.out.println("in " + getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LockSupport.park();
		System.out.println("out " + getName());
	}
}
