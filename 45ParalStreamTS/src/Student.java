import java.util.ArrayList;
import java.util.List;

public class Student {
	
	private int score;

	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	static List<Student> ss=new ArrayList<Student>();
	public static void main(String[] args) {
		ss.stream().mapToInt(s->s.score).average().getAsDouble();//串行流
		ss.parallelStream().mapToInt(s->s.score).average().getAsDouble();//并行流
	}

}
