/**
 * 
 */

/**   
*    
* 项目名称：JoinYieldTS   
* 类名称：AddThread   
* 类描述：
* 创建人：Hyman   
* 创建时间：2018年10月24日 下午1:50:55   
* @version        
*/
public class AddThread extends Thread {
	
	@Override
	public void run(){
		for(JoinMain.i=0;JoinMain.i<10000000;JoinMain.i++);
		//调用Thread.yield()表示该线程愿意出让资源
		Thread.yield();
	}
}
