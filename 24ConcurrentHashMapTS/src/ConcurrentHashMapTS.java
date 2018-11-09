import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTS implements Runnable {

	public static Map cmap = new ConcurrentHashMap();
	
	private int value;

	public ConcurrentHashMapTS(int value) {
		this.value = value;
	}
	
	@Override
	public void run() {
		cmap.put(this.value, this.value);
	}

}
