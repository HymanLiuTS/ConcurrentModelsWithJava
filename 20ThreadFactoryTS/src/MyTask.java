
public class MyTask implements Runnable {

	@Override
	public void run() {
		
		while(true){
			try {
				Thread.sleep(100);
				System.out.println(System.currentTimeMillis() + " Thread ID:" + Thread.currentThread().getId());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
