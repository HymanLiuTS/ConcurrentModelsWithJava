
public class PCData {

	private int intData;

	public PCData(int intData) {
		this.intData = intData;
	}

	public PCData(String intData) {
		this.intData = Integer.valueOf(intData);
	}

	public int getIntData() {
		return intData;
	}

	public String toString() {
		return "[Data=" + intData + "]";
	}
}
