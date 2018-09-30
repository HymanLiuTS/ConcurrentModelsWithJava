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
		while(true){
			System.out.println("Hello,I am child thread" + Thread.currentThread().getName());
			//�߳��ж�
			if(Thread.interrupted()){
				System.out.println("Hello,I am Interrupted!");
				return;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				//sleep���жϺ���׳�InterruptedException��������ж�λ
				Thread.currentThread().interrupt();
			}
			
		}
	}
}
