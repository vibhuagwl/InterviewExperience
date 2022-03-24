import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'weightCapacity' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER_ARRAY weights 2. INTEGER maxCapacity
	 */

	static int knapSack(int W, int wt[], int n) {
		if (n == 0 || W == 0)
			return 0;
		if (wt[n - 1] > W)
			return knapSack(W, wt, n - 1);
		else
			return Math.max(wt[n - 1] + knapSack(W - wt[n - 1], wt, n - 1), knapSack(W, wt, n - 1));
	}

	public static int weightCapacity(List<Integer> weights, int maxapacity) {
		int[] arr = weights.stream().mapToInt(i -> i).toArray();
		return knapSack(maxapacity, arr, arr.length);

	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int weightsCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> weights = IntStream.range(0, weightsCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int maxCapacity = Integer.parseInt(bufferedReader.readLine().trim());

		int result = Result.weightCapacity(weights, maxCapacity);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
