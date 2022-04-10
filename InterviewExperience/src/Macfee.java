import java.util.ArrayList;
import java.util.List;

public class Macfee {
	public static int finalProd = 1;

	/*
	 * public int max(int[] arr) { { if(array.length == 0) {
	 * 
	 * int max = Integer.MIN_VALUE; for(int res : result) { max = Math.max( max,
	 * res); } finalProd *= max; return result; } }
	 */

	public static void main(String[] args) {

		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		System.out.println(getSubSeq(arr));
		System.out.println(maxres);

	}

	static int maxres = 1;

	public static List<Integer> getSubSeq(List<Integer> arr) {
		if (arr.size() == 0) {
			ArrayList<Integer> res = new ArrayList<>();
			res.add(1);
			return res;
		}
		Integer left = arr.get(0);
		List<Integer> right = arr.subList(1, arr.size());
		List<Integer> finalResult = new ArrayList<>();
		List<Integer> result = getSubSeq(right);
		int max = Integer.MIN_VALUE;
		for (Integer s : result) {

			max = Math.max(max, s);
			finalResult.add(s);
		}
		for (Integer s : result) {
			max = Math.max(max, s);
			finalResult.add(left + s);
		}
		maxres *= Math.max(maxres, max);
		System.out.println(maxres + "---" + max);
		return finalResult;

	}
}
