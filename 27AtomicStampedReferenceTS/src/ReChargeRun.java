
public class ReChargeRun implements Runnable {

	final int timeStamp;

	public ReChargeRun(int timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public void run() {
		while (true) {
			Integer m = MainApp.money.getReference();
			if (m < 20) {
				if (MainApp.money.compareAndSet(m, m + 20, timeStamp, timeStamp + 1)) {
					System.out.println("余额小于20元，充值成功！最新余额：" + MainApp.money.getReference() + "元！");
				}
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
