
public class ReadRun implements Runnable {

	@Override
	public void run() {
		try {
			ReadWriteLockDemo.demo.handleRead(ReadWriteLockDemo.demo.readLock);
			System.out.println("value= " + ReadWriteLockDemo.demo.value);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
