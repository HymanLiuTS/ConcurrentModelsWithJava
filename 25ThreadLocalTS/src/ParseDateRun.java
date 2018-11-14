import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParseDateRun implements Runnable {

	private int i = 0;

	public ParseDateRun(int i) {
		this.i = i;
	}

	@Override
	public void run() {
		try {
			if (MainApp.tl.get() == null)
				MainApp.tl.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
			Date t = MainApp.tl.get().parse("2015-02-20 19:20:" + i % 60);
			System.out.println(i + ":" + t);
			MainApp.tl.remove();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
