
/**  
*  
*    
* 项目名称：VolatileTS   
* 类名称：ReaderThread   
* 类描述： 验证volatile保证可见性的类  
* 创建人：Hyman   
* 创建时间：2018年10月25日 上午9:19:10   
*
* @version        
*/
public class ReaderThread extends Thread {
	
	public volatile static boolean ready;
	public static int number;
	
	@Override
	public void run() {
		while(!ready);
		System.out.println(number);
	}
}
