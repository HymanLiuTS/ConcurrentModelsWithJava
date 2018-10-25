
public class ThreadGroupTS implements Runnable {

	@Override
	public void run() {
		System.out.println(String.format("I am in %s and my name is %s",
				Thread.currentThread().getThreadGroup().getName(), Thread.currentThread().getName()));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
