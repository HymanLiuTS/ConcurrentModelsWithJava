import java.util.ArrayList;
import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Long> {

	private static final int THRESHOLD = 10000;
	private long start;
	private long end;

	public CountTask(long start, long end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		long sum = 0;
		boolean canCompute = (this.end - this.start) < THRESHOLD;
		if (canCompute) {
			for (long i = start; i <= end; i++) {
				sum += i;
			}
		} else {
			long step = (start + end) / 100;
			ArrayList<CountTask> subTasks = new ArrayList<CountTask>();
			long pos = start;
			for (int i = 0; i < 100; i++) {
				long lastOne = pos + step;
				if (lastOne > end)
					lastOne = end;
				CountTask subTask = new CountTask(pos, lastOne);
				subTask.fork();
				sum += subTask.join();
			}
		}
		return sum;
	}

}
