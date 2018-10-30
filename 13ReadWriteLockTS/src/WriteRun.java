import java.util.Random;

public class WriteRun implements Runnable {

	@Override
	public void run() {
		try {
			int temp = new Random().nextInt();
			System.out.println("temp= " + temp);
			ReadWriteLockDemo.demo.handleWrite(ReadWriteLockDemo.demo.writeLock, temp);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
