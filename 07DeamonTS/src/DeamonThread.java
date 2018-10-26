
/**   
*    
* 项目名称：DeamonTS   
* 类名称：DeamonThread   
* 类描述： 	守护线程 
* 创建人：Hyman   
* 创建时间：2018年10月26日 上午10:41:07
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
