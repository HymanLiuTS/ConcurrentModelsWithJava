
public class ConsumeRun implements Runnable {

	@Override
	public void run() {
		while (true) {
			int timestamp = MainApp.money.getStamp();
			Integer m = MainApp.money.getReference();
			if (m > 10) {
				System.out.println("余额大于10元。");
				if (MainApp.money.compareAndSet(m, m - 10, timestamp, timestamp + 1)) {
					System.out.println("成功消费10元，余额" + MainApp.money.getReference() + "元！");
				}
			} else {
				System.out.println("没有足够的金额！");
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
