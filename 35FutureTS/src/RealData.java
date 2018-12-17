
public class RealData implements Data {

	protected final String result;

	public RealData(String para) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			sb.append(para);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		result = sb.toString();
	}

	@Override
	public String getResult() {

		return result;
	}

}