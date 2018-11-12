import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentSkipListMap;

public class MainApp {

	public static void main(String[] args) {
		Map<Integer, Integer> map = new ConcurrentSkipListMap<Integer, Integer>();
		for (int i = 0; i < 30; i++) {
			map.put(new Random().nextInt(100),i);
		}
		
		for(Map.Entry<Integer, Integer> extry:map.entrySet()){
			System.out.println(extry.getKey());
		}
	}

}
