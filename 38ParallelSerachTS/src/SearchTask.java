import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SearchTask implements Callable<Integer> {

	public static int[] arr;

	int begin, end, serachValue;

	public static ExecutorService pool = Executors.newCachedThreadPool();
	public static final int Thread_Num = 2;
	public static AtomicInteger result = new AtomicInteger(-1);

	public SearchTask(int searchValue, int begin, int end) {
		this.serachValue = searchValue;
		this.begin = begin;
		this.end = end;
	}

	@Override
	public Integer call() throws Exception {
		int re = search(this.serachValue, this.begin, this.end);
		return re;
	}

	public static int search(int searchValue, int begin, int end) {
		int i = 0;
		for (i = begin; i < end; i++) {
			if (result.get() > 0) {
				return result.get();
			}
			if (arr[i] == searchValue) {
				if (!result.compareAndSet(-1, i)) {
					return result.get();
				}
			}
		}
		return -1;
	}

}
