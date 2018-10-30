
public class MainApp {
	public static ReadWriteLockDemo demo = new ReadWriteLockDemo();

	public static void main(String[] args) {
		WriteRun wrun = new WriteRun();
		ReadRun rrun = new ReadRun();

		for (int i = 18; i < 20; i++) {
			new Thread(wrun).start();
		}
		
		for (int i = 0; i < 18; i++) {
			new Thread(rrun).start();
		}
	}

}
