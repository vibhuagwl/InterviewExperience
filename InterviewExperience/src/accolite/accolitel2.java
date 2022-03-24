package accolite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Merge two sorted lists For example, given following lists : 
 * 5 -> 8 -> 20 4 ->
 * 11 -> 15 The merged list should be :
 * 4 -> 5 -> 8 -> 11 -> 15 -> 20
 */
class accolitel2 {

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(5, 8, 20);
		List<Integer> list2 = Arrays.asList(4, 11, 15);
		merge(list1, list2).stream().forEach(System.out::print);
	}

	static List<Integer> merge(List<Integer> sortedList1, List<Integer> sortedList2) {
		ArrayList<Integer> result = new ArrayList<>();
		int length = sortedList1.size() > sortedList2.size() ? sortedList2.size() : sortedList1.size();
		int i = 0;
		int j = 0;
		while (i < length && j < length) {
			if (sortedList1.get(i) < sortedList2.get(j)) {
				result.add(sortedList1.get(i));
				i++;

			} else {
				result.add(sortedList2.get(j));
				j++;
			}
		}

		while (i < sortedList1.size()) {
			result.add(sortedList1.get(i));
			i++;
		}

		while (j < sortedList2.size()) {
			result.add(sortedList2.get(j));
			j++;
		}
		return result;
	}

}
