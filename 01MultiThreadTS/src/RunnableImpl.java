

/**   
*    
* ��Ŀ���ƣ�MultiThreadTS   
* �����ƣ�RunnableImpl   
* ��������ʵ��  Runnable�ӿڣ�Ϊ�������߳�ִ�в����ĵڶ��ַ�����
* �����ˣ�Hyman   
* ����ʱ�䣺2018��9��29�� ����11:10:51   
* @version        
*/
public class RunnableImpl implements Runnable {

	@Override
	public void run() {
		System.out.println("Hello,in " + RunnableImpl.class.getName());
	}

}
