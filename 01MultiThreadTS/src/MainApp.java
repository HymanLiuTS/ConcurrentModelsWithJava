
public class MainApp {

	public static void main(String[] args) {

		// ����ThreadChild���󣬿���һ�����߳�
		Thread t1 = new ThreadChild();
		t1.start();
		// ����һ��Thread���󣬴���ʱ��RunnableImpl��Ϊ�������ݽ�ȥ������һ�����߳�
		Thread t2 = new Thread(new RunnableImpl());
		t2.start();
	}
}
