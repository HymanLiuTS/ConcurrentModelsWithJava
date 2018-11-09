
public class MainApp {

	public static void main(String[] args) throws InterruptedException {
		long t1 = System.currentTimeMillis();
		System.out.println("SynchronizedMapTS ��ʼ��" + t1);
		for (int i = 0; i < 100000; i++) {
			Thread t=new Thread(new SynchronizedListTS(i));
			t.start();
			t.join();
		}
		System.out.println("SynchronizedListTS ��ʱ��" + (System.currentTimeMillis() - t1));
		
		t1 = System.currentTimeMillis();
		System.out.println("ConcurrentHashMapTS ��ʼ��" + t1);
		for (int i = 0; i < 100000; i++) {
			Thread t=new Thread(new VectorTS(i));
			t.start();
			t.join();
		}
		System.out.println("VectorTS ��ʱ��" + (System.currentTimeMillis() - t1));

	}

}
