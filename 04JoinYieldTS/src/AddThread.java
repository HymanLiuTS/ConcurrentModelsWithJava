/**
 * 
 */

/**   
*    
* ��Ŀ���ƣ�JoinYieldTS   
* �����ƣ�AddThread   
* ��������
* �����ˣ�Hyman   
* ����ʱ�䣺2018��10��24�� ����1:50:55   
* @version        
*/
public class AddThread extends Thread {
	
	@Override
	public void run(){
		for(JoinMain.i=0;JoinMain.i<10000000;JoinMain.i++);
		//����Thread.yield()��ʾ���߳�Ը�������Դ
		Thread.yield();
	}
}
