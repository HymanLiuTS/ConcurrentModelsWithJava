
public class MainApp {

	public static void main(String[] args) {
		new Thread(new Plus()).start();
		new Thread(new Multiply()).start();
		new Thread(new Div()).start();

		for (int i = 0; i <= 1000; i++) {
			for (int j = 0; j <= 1000; j++) {
				Msg msg = new Msg();
				msg.i = i;
				msg.j = j;
				msg.orgStr = String.format("((%d+%d)*%d)/2", i, j, i);
				Plus.bq.add(msg);
			}
		}
	}

}
