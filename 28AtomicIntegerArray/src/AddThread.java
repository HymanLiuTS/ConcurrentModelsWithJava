
public class AddThread implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<10000;i++){
			MainApp.array.getAndIncrement(i%MainApp.array.length());
		}
	}

}
