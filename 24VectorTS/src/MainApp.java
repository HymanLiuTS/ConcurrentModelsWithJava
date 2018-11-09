
public class MainApp {

	public static void main(String[] args) throws InterruptedException {
		long t1 = System.currentTimeMillis();
		System.out.println("SynchronizedMapTS 开始：" + t1);
		for (int i = 0; i < 100000; i++) {
			Thread t=new Thread(new SynchronizedListTS(i));
			t.start();
			t.join();
		}
		System.out.println("SynchronizedListTS 耗时：" + (System.currentTimeMillis() - t1));
		
		t1 = System.currentTimeMillis();
		System.out.println("ConcurrentHashMapTS 开始：" + t1);
		for (int i = 0; i < 100000; i++) {
			Thread t=new Thread(new VectorTS(i));
			t.start();
			t.join();
		}
		System.out.println("VectorTS 耗时：" + (System.currentTimeMillis() - t1));

	}

}
