
public class JoinMain {

	public volatile static int i=0;
	public static void main(String[] args) throws InterruptedException {
		AddThread at=new AddThread();
		at.start();
		//�ȴ��߳�at����
		at.join();
		System.out.println(i);
	}
}
