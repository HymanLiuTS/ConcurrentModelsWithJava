

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

	/**
	 * �̹߳رյı�־
	 */
	private boolean stopMe=false;
	
	/**
	 * ����stopMe
	 * @param stopMe the stopMe to set
	 * @author Hyman 
	 * 2018��9��30������9:32:10
	 */
	public void setStopMe(boolean stopMe) {
		this.stopMe = stopMe;
	}

	@Override
	public void run() {
		while(stopMe==false){
			try {
				
				System.out.println("Hello,in " + RunnableImpl.class.getName());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
