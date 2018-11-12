
public class ReadTS implements Runnable {

	@Override
	public void run() {
		while (MainApp.list.isEmpty() == false) {
			try {
				System.out.print(Thread.currentThread().getName() + ":" + MainApp.list.remove(0));
				Thread.sleep(150);
			} catch (Exception ex) {
				System.out.println("元素已经清空！");
			}
		}
	}

}
