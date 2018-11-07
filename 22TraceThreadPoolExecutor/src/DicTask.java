
public class DicTask implements Runnable {

	int a, b;

	public DicTask(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public void run() {
		double re = a / b;
		System.out.println(re);
	}

}
