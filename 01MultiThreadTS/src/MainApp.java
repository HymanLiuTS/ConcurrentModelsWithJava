
public class MainApp {

	public static void main(String[] args) throws InterruptedException {

		// 创建ThreadChild对象，开启一个子线程
		Thread t1 = new ThreadChild();
		t1.start();
		// 创建一个Thread对象，创建时将RunnableImpl作为参数传递进去，开启一个子线程
		RunnableImpl rimpl=new RunnableImpl();
		Thread t2 = new Thread(rimpl);
		t2.start();
		Thread.sleep(5000);
		t1.interrupt();
		Thread.sleep(10000);
		//停止线程
		rimpl.setStopMe(true);
	}
}
