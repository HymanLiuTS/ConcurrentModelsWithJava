import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApp {

	public static void main(String[] args) {
		MyTask mt = new MyTask();
		//����һ�����й̶��߳��������̳߳�
		//ExecutorService service = Executors.newFixedThreadPool(5);
		//����һ��ֻ����һ���̵߳��̳߳�
		//ExecutorService service = Executors.newSingleThreadExecutor();
		//����һ�����ж�̬�����̵߳��̳߳�
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			service.submit(mt);
		}
		
	}
}
