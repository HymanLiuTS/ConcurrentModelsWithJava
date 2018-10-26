
public class LockInstanceMethodRunnable implements Runnable {

	public static int i=0;
	
	@Override
	public void run() {
		for(int j=0;j<100000;j++){
			increase();
		}

	}
	public synchronized void increase(){
		i++;
	}

}
