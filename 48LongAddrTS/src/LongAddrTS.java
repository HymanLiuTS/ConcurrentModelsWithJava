import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class LongAddrTS {

	private static final int MAX_THREADS = 3;
	private static final int TASK_COUNT = 3;
	private static final int TARGET_COUNT = 10000000;

	private AtomicLong account = new AtomicLong(0L);
	private LongAdder laccount = new LongAdder();
	private long count = 0;

	static CountDownLatch cdlsync = new CountDownLatch(TASK_COUNT);
	static CountDownLatch cdlatomic = new CountDownLatch(TASK_COUNT);
	static CountDownLatch cdladdr = new CountDownLatch(TASK_COUNT);

	protected synchronized long inc() {
		return ++count;
	}

	protected synchronized long getCount() {
		return count;
	}

	public class SyncThread implements Runnable {

		protected String name;
		protected long starttime;
		LongAddrTS out;

		public SyncThread(LongAddrTS o, long starttime) {
			this.out = o;
			this.starttime = starttime;
		}

		@Override
		public void run() {
			long v=out.getCount();
			while(v<TARGET_COUNT){
				v=out.inc();
			}
			long endtime=System.currentTimeMillis();
			System.out.println("SyncThread spend: "+(endtime-starttime)+"ms"+" v="+v);
			cdlsync.countDown();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
