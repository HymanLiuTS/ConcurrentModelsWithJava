import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SynchronizedListTS implements Runnable {

	public static List list = Collections.synchronizedList(new LinkedList());

	private int value;

	public SynchronizedListTS(int value) {
		this.value = value;
	}
	
	@Override
	public void run() {
		list.add(value);
	}

}
