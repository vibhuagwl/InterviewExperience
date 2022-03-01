package accolite;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Pair implements Comparable<Pair> {
	String name;
	int marks;

	public Pair(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}

	@Override
	public int compareTo(Pair o) {
		return this.marks - o.marks;
	}

	public int getMarks() {
		return marks;
	}

	public String getName() {
		return name;
	}

}

public class accolitel1 {

	public static int step(int n, int[] dp) {
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			if (i >= 2) {
				dp[i] = dp[i - 1] + dp[i - 2];
			} else {
				dp[i] = dp[i - 1];
			}
		}
		return dp[n];
	}

	// 10,20,30,dequeue,40,dequeue
	// st1 - 20
	// st2 - 40,30

	public static void main(String[] args) {

		// denormalization benefits
		// arr = 1ton size = n-2; o(1)
		// max salary
		// fibonacci
		// database query optimization

		String str = new String();
		str.contains("a");

		List<Pair> list = new ArrayList<>();
		list.add(new Pair("Vibhu", 10));
		list.add(new Pair("Agarwal", 20));
		list.add(new Pair("Sam", 30));
		list.stream().sorted(Comparator.comparingInt(Pair::getMarks)).limit(3);
	}

	// select e.name from row_number over(e.salary order by e,salary) as salary
	// where n= 5;

	public void doComputation(String str) {
		str = new String();

	}

}
