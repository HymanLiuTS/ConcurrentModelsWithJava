import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApp {

	public static CopyOnWriteArrayList list = new CopyOnWriteArrayList();

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(5);
		es.submit(new WriteTS());
		es.submit(new ReadTS());
		es.submit(new ReadTS());
		es.submit(new ReadTS());
		es.submit(new ReadTS());
		es.submit(new ReadTS());
	}

}
