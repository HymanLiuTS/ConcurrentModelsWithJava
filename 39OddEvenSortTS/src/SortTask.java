import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SortTask implements Runnable {

	public int[] arr = null;
	static int exchFlag = 1;

	static synchronized void setExchFlag(int v) {
		exchFlag = v;
	}

	static synchronized int getExchFlag() {
		return exchFlag;
	}

	int i = 0;

	CountDownLatch latch = null;

	public SortTask(CountDownLatch latch, int[] arr, int i) {
		this.latch = latch;
		this.arr = arr;
		this.i = i;
	}

	@Override
	public void run() {
		if (arr[i] > arr[i + 1]) {
			int temp = arr[i];
			arr[i] = arr[i + 1];
			arr[i + 1] = temp;
			setExchFlag(1);
		}
		latch.countDown();
	}

	public static void pOddEvenSort(int[] arr) throws InterruptedException {
		int start = 0;
		ExecutorService pool = Executors.newCachedThreadPool();
		while (getExchFlag() == 1 || start == 1) {
			setExchFlag(0);
			CountDownLatch latch = new CountDownLatch(arr.length / 2 - (arr.length % 2 == 0 ? start : 0));
			for (int i = start; i < arr.length; i += 2) {
				pool.submit(new SortTask(latch, arr, i));
			}
			latch.await();
			if (start == 0)
				start = 1;
			else
				start = 0;
		}
	}
}
