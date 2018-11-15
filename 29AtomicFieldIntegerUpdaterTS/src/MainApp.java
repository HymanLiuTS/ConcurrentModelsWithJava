import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class MainApp {

	public final static AtomicIntegerFieldUpdater<Candidate> scoreUpdate = AtomicIntegerFieldUpdater
			.newUpdater(Candidate.class, "score");

	public static AtomicInteger allScore = new AtomicInteger(0);

	public static Candidate candidate = new Candidate();
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread[] ts = new Thread[10000];
		for (int i = 0; i < 10000; i++) {
			ts[i] = new Thread(new AddThread());
			ts[i].start();
		}
		for (int i = 0; i < 10000; i++) {
			ts[i].join();
		}
		System.out.println("score=" + candidate.score);
		System.out.println("allScore=" + allScore.get());
	}

}
