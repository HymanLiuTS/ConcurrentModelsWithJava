import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class MainApp {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		long bgms = System.currentTimeMillis();
		System.out.println(bgms + "����ʼ�������");
		SearchTask.arr = new int[10000000];
		Random random = new Random();
		for (int i = 0; i < 10000000; i++) {
			SearchTask.arr[i] = random.nextInt(i + 1);
		}
		long edms = System.currentTimeMillis();
		System.out.println(edms + "�����������ɣ���ʱ" + (edms - bgms) + "����");

		int searchValue = random.nextInt(500000);
		bgms = System.currentTimeMillis();
		System.out.println(bgms + "����ʼ����Ŀ������" + searchValue);
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
			System.out.println(edms + "���ҵ�Ŀ������,����" + SearchTask.result.get() + "����ʱ" + (edms - bgms) + "����");
		else
			System.out.println(edms + "��δ�ҵ�Ŀ�����֣���ʱ" + (edms - bgms) + "����");
	}

}
