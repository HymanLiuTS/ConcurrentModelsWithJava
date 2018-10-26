
public class MainApp {

	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(new LockObjectRunnable());
		Thread t2 = new Thread(new LockObjectRunnable());
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		System.out.println("LockObjectRunnable.i = " + LockObjectRunnable.i);

		// 使用synckronized修饰实例方法时，必须new Thread()时传入同一个runnable
		LockInstanceMethodRunnable run = new LockInstanceMethodRunnable();
		Thread t3 = new Thread(run);
		Thread t4 = new Thread(run);
		t3.start();
		t3.join();
		t4.start();
		t4.join();
		System.out.println("LockInstanceMethodRunnable.i = " + LockInstanceMethodRunnable.i);

		Thread t5 = new Thread(new LockStaticMethodRunnable());
		Thread t6 = new Thread(new LockStaticMethodRunnable());
		t5.start();
		t5.join();
		t6.start();
		t6.join();
		System.out.println("LockStaticMethodRunnable.i = " + LockStaticMethodRunnable.i);
	}

}
