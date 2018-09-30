

/**   
*    
* 项目名称：MultiThreadTS   
* 类名称：RunnableImpl   
* 类描述：实现  Runnable接口，为创建子线程执行操作的第二种方法。
* 创建人：Hyman   
* 创建时间：2018年9月29日 上午11:10:51   
* @version        
*/
public class RunnableImpl implements Runnable {

	/**
	 * 线程关闭的标志
	 */
	private boolean stopMe=false;
	
	/**
	 * 设置stopMe
	 * @param stopMe the stopMe to set
	 * @author Hyman 
	 * 2018年9月30日上午9:32:10
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
