import java.util.Arrays;
import java.util.Random;

public class ParalSort {

	public static void main(String[] args) {
		int[] arr=new int[10000];
		Arrays.parallelSort(arr);//并行排序
		Random random=new Random();
		Arrays.parallelSetAll(arr, (i)->i=random.nextInt());//并行赋值
	}

}
