import java.util.concurrent.atomic.AtomicStampedReference;

public class MainApp {

	public static AtomicStampedReference<Integer> money = new AtomicStampedReference<Integer>(19, 0);

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			int timestamp = money.getStamp();
			new Thread(new ReChargeRun(timestamp)).start();
		}
		new Thread(new ConsumeRun()).start();
	}
}
