
public class LockObjectRunnable implements Runnable {

	public static int i=0;
	public static LockObjectRunnable lock = new LockObjectRunnable();
	
	@Override
	public void run() {
		for(int j=0;j<100000;j++){
			synchronized(lock){
				i++;
			}
		}
	}
	
	
}
