import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainApp {

	public static void main(String[] args) {
		MyTask mt = new MyTask();
		//����ֻ����һ��ScheduledExecutor�����̳߳�
		//ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		//�������й̶�������ScheduledExecutor������̳߳�
		ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
		System.out.println(System.currentTimeMillis()/1000 + ":Thread ID:" + Thread.currentThread().getId());
		for (int i = 0; i < 1; i++) {
			//�ӳ�������ִ��
			//service.schedule(mt, 2, TimeUnit.SECONDS);
			//��ʼ�ӳ����룬Ȼ���Կ�ʼʱ���Ϊ��׼ÿ1��ִ��һ���̺߳���
			//service.scheduleAtFixedRate(mt, 2, 1, TimeUnit.SECONDS);
			//��ʼ�ӳ����룬Ȼ�����ϴ�����Ľ���ʱ�䵽�������Ŀ�ʼʱ����Ϊ1�����ִ��
			service.scheduleWithFixedDelay(mt, 2, 1, TimeUnit.SECONDS);
		}

	}

}