
public class JoinMain {

	public volatile static int i=0;
	public static void main(String[] args) throws InterruptedException {
		AddThread at=new AddThread();
		at.start();
		//等待线程at结束
		at.join();
		System.out.println(i);
	}
}
