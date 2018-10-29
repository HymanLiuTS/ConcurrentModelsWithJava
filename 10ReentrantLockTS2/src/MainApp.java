
public class MainApp {

	public static void main(String[] args) throws InterruptedException {
		ReenterLock rl=new ReenterLock();
		Thread t1=new Thread(null,rl,"t1");
		Thread t2=new Thread(null,rl,"t2");
		t1.start();t2.start();
		t1.join();t2.join();
	}

}
