/**   
*    
* ��Ŀ���ƣ�MultiThreadTS   
* �����ƣ�ThreadChild   
* ���������̳���Thread���࣬����run()������Ϊ�������߳�ִ�в����ĵ�һ�ַ���
* �����ˣ�Hyman   
* ����ʱ�䣺2018��9��29�� ����11:06:53   
* @version        
*/
public class ThreadChild extends Thread {

	@Override
	public void run() {
		System.out.println("Hello,I am child thread" + Thread.currentThread().getName());
	}
}
