

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

	@Override
	public void run() {
		System.out.println("Hello,in " + RunnableImpl.class.getName());
	}

}
