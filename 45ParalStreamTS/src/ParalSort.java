import java.util.Arrays;
import java.util.Random;

public class ParalSort {

	public static void main(String[] args) {
		int[] arr=new int[10000];
		Arrays.parallelSort(arr);//��������
		Random random=new Random();
		Arrays.parallelSetAll(arr, (i)->i=random.nextInt());//���и�ֵ
	}

}
