
public class MyTask implements Runnable {

	private Exception exception;

	public Runnable task;

	public String threadName;

	public MyTask(Runnable task, Exception exception, String threadName) {
		this.task = task;
		this.exception = exception;
		this.threadName = threadName;
	}

	@Override
	public void run() {
		try {
			task.run();
		} catch (Exception e) {
			exception.printStackTrace();
			throw e;
		}

	}

}
