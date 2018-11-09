import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SynchronizedMapTS implements Runnable {

	public static Map smap = Collections.synchronizedMap(new HashMap());

	private int value;

	public SynchronizedMapTS(int value) {
		this.value = value;
	}

	@Override
	public void run() {
		smap.put(this.value, this.value);
	}

}
