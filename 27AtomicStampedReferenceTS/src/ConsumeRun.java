
public class ConsumeRun implements Runnable {

	@Override
	public void run() {
		while (true) {
			int timestamp = MainApp.money.getStamp();
			Integer m = MainApp.money.getReference();
			if (m > 10) {
				System.out.println("������10Ԫ��");
				if (MainApp.money.compareAndSet(m, m - 10, timestamp, timestamp + 1)) {
					System.out.println("�ɹ�����10Ԫ�����" + MainApp.money.getReference() + "Ԫ��");
				}
			} else {
				System.out.println("û���㹻�Ľ�");
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
