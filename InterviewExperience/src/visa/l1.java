package visa;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

class l1 {

	public int binarySearch(int arr[], int l, int r, int x) {
		if (r >= l) {
			int mid = l + (r - l) / 2;
			if (arr[mid] == x) {
				return mid;
			}
			if (arr[mid] > x) {
				return binarySearch(arr, l, mid + 1, x);
			}
			return binarySearch(arr, l, mid + 1, x);
		}
		return -1;
	}

	static String digitletter[] = { "", "ab", "cde", "fgh", "ijk", "lmn", "opq", "rst", "uvw", "xyz" };

	public static void main(String[] args) throws IOException {

		System.out.println(map.get('a'));
		System.out.println(Arrays.asList(digitletter).indexOf("ab"));
		System.out.println(Arrays.stream(digitletter).anyMatch("a"::equalsIgnoreCase));
		combine(0, prepareDictionary());
	}

	public static boolean containsChar(String s, char search) {
		if (s.length() == 0)
			return false;
		else
			return s.charAt(0) == search || containsChar(s.substring(1), search);
	}

	static String inputstring = "bef";
	static StringBuffer output = new StringBuffer();

	static HashMap<Character, Integer> map = new HashMap<>();

	public static int ocount = 0;

	private static void combine(int start, HashMap<Character, Integer> map) {
		for (int i = start; i < inputstring.length(); ++i) {
			output.append(inputstring.charAt(i));

			int sum = 0;
			for (int j = 0; j < output.length(); j++) {
				sum += map.get(output.charAt(j));
			}
			if (sum % output.length() == 0) {
				ocount++;
			}

			if (i < inputstring.length())
				combine(i + 1, map);
			output.setLength(output.length() - 1);
		}
	}

	public static HashMap<Character, Integer> prepareDictionary()

	{
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('a', 1);
		map.put('b', 1);
		map.put('c', 2);
		map.put('d', 2);
		map.put('e', 2);
		map.put('f', 3);
		map.put('g', 3);
		map.put('h', 3);
		map.put('i', 4);
		map.put('j', 4);
		map.put('k', 4);
		map.put('l', 5);
		map.put('m', 5);
		map.put('n', 5);
		map.put('o', 6);
		map.put('p', 6);
		map.put('q', 6);
		map.put('r', 7);
		map.put('s', 7);
		map.put('t', 7);
		map.put('u', 8);
		map.put('v', 8);
		map.put('w', 8);
		map.put('x', 9);
		map.put('y', 9);
		map.put('z', 9);
		return map;

	}
}