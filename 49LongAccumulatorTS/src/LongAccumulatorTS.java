import java.util.Random;
import java.util.concurrent.atomic.LongAccumulator;

public class LongAccumulatorTS {

	public static long max(long i, long j) {
		return i > j ? i : j;
	}

	public static void main(String[] args) throws InterruptedException {

		LongAccumulator accumulator = new LongAccumulator(LongAccumulatorTS::max, Long.MIN_VALUE);
		Thread[] ts = new Thread[1000];
		for (int i = 0; i < 1000; i++) {
			ts[i] = new Thread(() -> {
				Random random = new Random();
				long value = random.nextLong();
				accumulator.accumulate(value);
			});
			ts[i].start();
		}
		for (int i = 0; i < 1000; i++) {
			ts[i].join();
		}
		System.out.println(accumulator.longValue());
	}

}
