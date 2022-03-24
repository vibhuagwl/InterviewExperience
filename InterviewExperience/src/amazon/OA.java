package amazon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class OA {

	/*
	 * Complete the 'findMaximumSustainableClusterSize' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER_ARRAY processingPower 2. INTEGER_ARRAY bootingPower 3.
	 * LONG_INTEGER powerMax
	 */

	public static int findMaximumSustainableClusterSize(List<Integer> processingPower, List<Integer> bootingPower,
			long powerMax) {
		if (processingPower == null || bootingPower == null || processingPower.size() == 0
				|| processingPower.size() != bootingPower.size()) {
			return 0;
		} // Write your code here
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
		int maxLength = 0;
		int currrentLength = 1;
		int start = 0;
		int end = 0;
		int currentSumProcessingPower = processingPower.get(0);
		pq.add(bootingPower.get(0));
		while (end < processingPower.size()) {
			int currentbootingpower = pq.peek();
			int currentPower = currentbootingpower + currentSumProcessingPower * currrentLength;
			if (currentPower <= powerMax) {
				maxLength = currrentLength;
				end++;
				currrentLength++;
			} else {
				currentSumProcessingPower -= processingPower.get(start);
				pq.remove(bootingPower.get(start));
				start++;
				end--;
			}
			if (end < processingPower.size()) {
				pq.add(bootingPower.get(end));
				currentSumProcessingPower += processingPower.get(end);
			}
		}
		return maxLength;

	}

	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		findMaximumSustainableClusterSize(l1, l1, 10);

	}

}
