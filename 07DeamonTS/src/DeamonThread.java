
/**   
*    
* ��Ŀ���ƣ�DeamonTS   
* �����ƣ�DeamonThread   
* �������� 	�ػ��߳� 
* �����ˣ�Hyman   
* ����ʱ�䣺2018��10��26�� ����10:41:07
 * 
 * @version
 */
public class DeamonThread extends Thread {

	@Override
	public void run() {
		while (true) {
			System.out.println("I am alive");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
}
