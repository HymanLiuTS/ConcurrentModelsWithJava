package codenest.MatrixComputeTS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.RecursiveTask;

import org.jmatrices.dbl.Matrix;
import org.jmatrices.dbl.operator.MatrixOperator;

public class MatrixMultiTask extends RecursiveTask<Matrix> {

	static final int granularity = 3;
	Matrix m1;
	Matrix m2;
	String pos;;

	public MatrixMultiTask(Matrix m1, Matrix m2, String pos) {
		this.m1 = m1;
		this.m2 = m2;
		this.pos = pos;
	}

	@Override
	protected Matrix compute() {

		if (this.m1.rows() < granularity || m2.cols() <= granularity) {
			Matrix mRe = MatrixOperator.multiply(m1, m2);
			return mRe;
		} else {
			int rows;
			rows = m1.rows();
			// 左乘矩阵横向分割
			Matrix m11 = m1.getSubMatrix(1, 1, rows / 2, m1.cols());
			Matrix m12 = m1.getSubMatrix(rows / 2 + 1, 1, m1.rows(), m1.cols());
			// 右乘矩阵横向分割
			Matrix m21 = m2.getSubMatrix(1, 1, m2.rows(), m2.cols() / 2);
			Matrix m22 = m2.getSubMatrix(1, m2.cols() / 2 + 1, m2.rows(), m2.cols());

			ArrayList<MatrixMultiTask> subTasks = new ArrayList<MatrixMultiTask>();
			MatrixMultiTask tmp = null;
			tmp = new MatrixMultiTask(m11, m21, "m1");
			subTasks.add(tmp);
			tmp = new MatrixMultiTask(m11, m22, "m2");
			subTasks.add(tmp);
			tmp = new MatrixMultiTask(m12, m21, "m3");
			subTasks.add(tmp);
			tmp = new MatrixMultiTask(m12, m22, "m4");
			subTasks.add(tmp);
			for (MatrixMultiTask t : subTasks) {
				t.fork();
			}

			Map<String, Matrix> matrixMap = new HashMap<String, Matrix>();
			for (MatrixMultiTask t : subTasks) {
				matrixMap.put(t.pos, t.join());
			}
			Matrix tmp1 = MatrixOperator.horizontalConcatenation(matrixMap.get("m1"), matrixMap.get("m2"));
			Matrix tmp2 = MatrixOperator.horizontalConcatenation(matrixMap.get("m3"), matrixMap.get("m4"));
			Matrix reM = MatrixOperator.verticalConcatenation(tmp1, tmp2);
			return reM;
		}
	}

}
