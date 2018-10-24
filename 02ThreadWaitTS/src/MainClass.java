
public class MainClass {

	public static Object lockObj = new Object();

	public static void main(String[] args) {
		WaitClass wt = new WaitClass();
		wt.start();
		NotifyClass nt = new NotifyClass();
		
		nt.start();
	}

}
