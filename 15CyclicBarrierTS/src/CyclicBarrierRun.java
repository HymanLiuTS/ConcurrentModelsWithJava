
public class CyclicBarrierRun implements Runnable {

	Boolean flag = true;

	public CyclicBarrierRun(Boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		if (flag) {
			System.out.println("所有士兵集合完毕，开始进行任务。");
			flag = false;
		} else {
			System.out.println("所有士兵完成任务。");
		}

	}

}
