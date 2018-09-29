/**   
*    
* 项目名称：MultiThreadTS   
* 类名称：ThreadChild   
* 类描述：继承自Thread基类，重载run()方法，为创建子线程执行操作的第一种方法
* 创建人：Hyman   
* 创建时间：2018年9月29日 上午11:06:53   
* @version        
*/
public class ThreadChild extends Thread {

	@Override
	public void run() {
		System.out.println("Hello,I am child thread" + Thread.currentThread().getName());
	}
}
