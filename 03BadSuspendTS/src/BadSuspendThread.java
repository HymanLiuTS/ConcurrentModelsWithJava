
/**   
*    
* ��Ŀ���ƣ�BadSuspendTS   
* �����ƣ�BadSuspendThread   
* ����������֤ʹ��suspend��resume�����ƹ���ͼ����߳̿��ܳ��ֵ�����
* �����ˣ�Hyman   
* ����ʱ�䣺2018��10��24�� ����10:51:49   
* @version        
*/
public class BadSuspendThread extends Thread {
	private static Object lockObj = new Object();

	public BadSuspendThread(String name) {
		super.setName(name);
	}

	@Override
	public void run() {
		synchronized (lockObj) {
			System.out.println("in " + this.getName());
			Thread.currentThread().suspend();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		BadSuspendThread t1=new BadSuspendThread("t1");
		BadSuspendThread t2=new BadSuspendThread("t2");
		t1.start();
		Thread.sleep(1000);
		t2.start();
		t1.resume();
		t2.resume();
		t1.join();
		t2.join();
	}

}
