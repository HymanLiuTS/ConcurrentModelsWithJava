
public class MainApp {

	public static void main(String[] args) throws InterruptedException {

		// ����ThreadChild���󣬿���һ�����߳�
		Thread t1 = new ThreadChild();
		t1.start();
		// ����һ��Thread���󣬴���ʱ��RunnableImpl��Ϊ�������ݽ�ȥ������һ�����߳�
		RunnableImpl rimpl=new RunnableImpl();
		Thread t2 = new Thread(rimpl);
		t2.start();
		Thread.sleep(5000);
		t1.interrupt();
		Thread.sleep(10000);
		//ֹͣ�߳�
		rimpl.setStopMe(true);
	}
}
