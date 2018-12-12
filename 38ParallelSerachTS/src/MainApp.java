import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class MainApp {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		long bgms = System.currentTimeMillis();
		System.out.println(bgms + "：开始填充数组");
		SearchTask.arr = new int[10000000];
		Random random = new Random();
		for (int i = 0; i < 10000000; i++) {
			SearchTask.arr[i] = random.nextInt(i + 1);
		}
		long edms = System.currentTimeMillis();
		System.out.println(edms + "：填充数组完成，耗时" + (edms - bgms) + "毫秒");

		int searchValue = random.nextInt(500000);
		bgms = System.currentTimeMillis();
		System.out.println(bgms + "：开始查找目标数字" + searchValue);
		int subArrSize = SearchTask.arr.length / (SearchTask.Thread_Num + 1);
		List<Future<Integer>> re = new ArrayList<Future<Integer>>();

		for (int i = 0; i < SearchTask.arr.length; i += subArrSize) {
			int end = i + subArrSize;
			if (end > SearchTask.arr.length)
				end = SearchTask.arr.length;
			re.add(SearchTask.pool.submit(new SearchTask(searchValue, i, end)));
		}

		for (Future<Integer> fu : re) {
			if (fu.get() >= 0) {
				break;
			}
		}
		edms = System.currentTimeMillis();
		if (SearchTask.result.get() > 0)
			System.out.println(edms + "：找到目标数字,索引" + SearchTask.result.get() + "，耗时" + (edms - bgms) + "毫秒");
		else
			System.out.println(edms + "：未找到目标数字，耗时" + (edms - bgms) + "毫秒");
	}

}
