
/**  
*  
*    
* ��Ŀ���ƣ�VolatileTS   
* �����ƣ�ReaderThread   
* �������� ��֤volatile��֤�ɼ��Ե���  
* �����ˣ�Hyman   
* ����ʱ�䣺2018��10��25�� ����9:19:10   
*
* @version        
*/
public class ReaderThread extends Thread {
	
	public volatile static boolean ready;
	public static int number;
	
	@Override
	public void run() {
		while(!ready);
		System.out.println(number);
	}
}
