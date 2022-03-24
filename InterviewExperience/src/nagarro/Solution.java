package nagarro;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;

class Result {

	/*
	 * Complete the 'weightCapacity' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER_ARRAY weights 2. INTEGER maxCapacity
	 */

	static int knapSack(int maxapacity, int wt[], int arrLength) {
		if (arrLength == 0 || maxapacity == 0)
			return 0;
		if (wt[arrLength - 1] > maxapacity)
			return knapSack(maxapacity, wt, arrLength - 1);
		else
			return Math.max(wt[arrLength - 1] + knapSack(maxapacity - wt[arrLength - 1], wt, arrLength - 1),
					knapSack(maxapacity, wt, arrLength - 1));
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
