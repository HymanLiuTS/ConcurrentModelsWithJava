package codenest.MatrixComputeTS;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

import org.jmatrices.dbl.Matrix;
import org.jmatrices.dbl.MatrixFactory;

public class App {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ForkJoinPool pool = new ForkJoinPool();
		Matrix m1=MatrixFactory.getRandomMatrix(300, 300, null);
		Matrix m2=MatrixFactory.getRandomMatrix(300, 300, null);
		MatrixMultiTask task=new MatrixMultiTask(m1,m2,null);
		ForkJoinTask<Matrix> result=pool.submit(task);
		Matrix pr=result.get();
		System.out.println(pr);
	}
}
