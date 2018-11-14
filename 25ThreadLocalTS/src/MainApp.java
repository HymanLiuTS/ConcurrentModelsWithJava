import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApp {

	public static final ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<SimpleDateFormat>();

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 1000; i++) {
			es.execute(new ParseDateRun(i));
		}
	}

}
