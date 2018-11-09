import java.util.Vector;

public class VectorTS implements Runnable {

	public static Vector v = new Vector();

	private int value;

	public VectorTS(int value) {
		this.value = value;
	}

	@Override
	public void run() {
		v.add(value);
	}

}
