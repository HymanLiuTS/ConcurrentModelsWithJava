
public class CyclicBarrierRun implements Runnable {

	Boolean flag = true;

	public CyclicBarrierRun(Boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		if (flag) {
			System.out.println("����ʿ��������ϣ���ʼ��������");
			flag = false;
		} else {
			System.out.println("����ʿ���������");
		}

	}

}
