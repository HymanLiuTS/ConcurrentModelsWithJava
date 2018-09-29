
public class MainApp {

	public static void main(String[] args) {

		// 创建ThreadChild对象，开启一个子线程
		Thread t1 = new ThreadChild();
		t1.start();
		// 创建一个Thread对象，创建时将RunnableImpl作为参数传递进去，开启一个子线程
		Thread t2 = new Thread(new RunnableImpl());
		t2.start();
	}
}
