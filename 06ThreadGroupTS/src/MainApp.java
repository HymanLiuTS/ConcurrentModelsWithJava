
public class MainApp {

	public static void main(String[] args) {
		ThreadGroup tg=new ThreadGroup("Print Group");
		Thread t1=new Thread(tg,new ThreadGroupTS(),"t1");
		Thread t2=new Thread(tg,new ThreadGroupTS(),"t2");
		t1.start();
		System.out.println(tg.activeCount());
		t2.start();
		
		tg.list();
	}

}
