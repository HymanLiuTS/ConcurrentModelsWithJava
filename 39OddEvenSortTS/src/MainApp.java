import java.util.Random;

public class MainApp {

	public static void main(String[] args) throws InterruptedException {
		Random random = new Random();
		int[] arr = new int[1000];
		for (int i = 0; i < 1000; i++) {
			arr[i] = random.nextInt(10000);
		}
		SortTask.pOddEvenSort(arr);
		String rt = "";
		for (int v : arr) {
			rt += v + ",";
		}
		System.out.println(rt);
	}

}
