import java.util.concurrent.CyclicBarrier;

public class MainApp {

	public static void main(String[] args) {

		Boolean flag = true;
		CyclicBarrier barrier = new CyclicBarrier(10,new CyclicBarrierRun(flag));
		Thread[] threads = new Thread[10];
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new SoliderRun("Ê¿±ø" + (i + 1), barrier));
			threads[i].start();
		}

	}

}
