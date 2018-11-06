
public class MyTask implements Runnable {

	public String name;

	public MyTask(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println("����ִ�� " + ":ThreadID��" + Thread.currentThread().getId() + ",Task Name=" + this.name);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
