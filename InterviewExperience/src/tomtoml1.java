import java.util.Arrays;

public class tomtoml1 {

	public static void findItem(String[] arr) {

		int size = arr.length;
		if (size == 0) {
			System.out.println("Longest common prefix: ");
		} else if (size == 1) {
			System.out.println("Longest common prefix: " + arr[0]);
		} else {
			Arrays.sort(arr);
			int length = arr[0].length();
			StringBuilder res = new StringBuilder();
			for (int i = 0; i < length; i++) {
				if (arr[0].charAt(i) == arr[size - 1].charAt(i)) {
					res.append(arr[0].charAt(i));
				} else {
					break;
				}
			}
			String result = res.toString();
			System.out.println("Longest common prefix: " + result);
		}
	}

	public static String findstem(String arr[]) {
		int n = arr.length;
		String s = arr[0];
		int len = s.length();
		String res = "";
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j <= len; j++) {
				String stem = s.substring(i, j);
				int k = 1;
				for (k = 1; k < n; k++) {
					if (!arr[k].contains(stem))
						break;
				}
				if (k == n && res.length() < stem.length())
					res = stem;
			}
		}
		return res;
	}

	public static void main(String args[]) {
		String arr[] = { "grace", "graceful", "disgraceful", "gracefully" };
		String stems = findstem(arr);
		findItem(arr);
		System.out.println(stems);
	}
//alpha & gamma
}
