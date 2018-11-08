import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class MainApp {

	public static void main(String[] args) {
		ForkJoinPool forJoinPool = new ForkJoinPool();
		CountTask task = new CountTask(0, 200000L);
		ForkJoinTask result = forJoinPool.submit(task);
		try {
			long res = (long) result.get();
			System.out.println("sum=" + res);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
