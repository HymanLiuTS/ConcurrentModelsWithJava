
public class ReadRun implements Runnable {

	@Override
	public void run() {
		while (MainApp.queue.isEmpty() == false) {
			try {
				System.out.print(MainApp.queue.remove());
				Thread.sleep(150);
			} catch (Exception ex) {
				System.out.println("元素已经清空！");
			}
		}
	}

}
