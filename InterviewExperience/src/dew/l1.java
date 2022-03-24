package dew;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class l1 {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 2, 3, 4, 5, 6 };
		int leftProd[] = new int[arr.length];
		int rightProd[] = new int[arr.length];
		leftProd[0] = arr[0];
		rightProd[arr.length - 1] = arr[arr.length - 1];
		int k = 1;
		for (int i = 1; i < arr.length; i++) {
			leftProd[k++] = arr[i] * leftProd[i - 1];
		}

		k = arr.length - 2;
		for (int i = arr.length - 2; i >= 0; i--) {
			rightProd[k--] = arr[i] * rightProd[i + 1];
		}

		int[] res = new int[arr.length];
		res[0] = rightProd[1];
		res[arr.length - 1] = leftProd[arr.length - 2];
		k = 1;
		for (int i = 1; i < arr.length - 1; i++) {
			res[k++] = leftProd[i - 1] * rightProd[i + 1];
		}
		System.out.println(Arrays.toString(res));

		// Ques -2
		Map<String, Integer> map = new HashMap<>();
		map.put("c", 3);
		map.put("b", 2);
		map.put("a", 1);
		map.put("d", 4);
		map.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		map.entrySet().stream().sorted((i1, i2) -> i1.getValue().compareTo(i2.getValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

	}

}
