
public class MyTask implements Runnable {

	@Override
	public void run() {
		System.out.println(System.currentTimeMillis()/1000 + ":Thread ID:" + Thread.currentThread().getId());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
