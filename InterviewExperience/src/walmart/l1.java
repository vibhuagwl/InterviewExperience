package walmart;

import java.util.Arrays;
import java.util.Comparator;

public class l1 {

	public static int nthLargestElement(int[] arr, int n) {
		Arrays.sort(arr);
		return arr[n - 1];
	}

	public static String[] reorderLogFiles(String[] logs) {

		Comparator<String> myComp = new Comparator<String>() {
			@Override
			public int compare(String log1, String log2) {
				// split each log into two parts: <identifier, content>
				String[] id1 = log1.split(" ", 2);
				String[] id2 = log2.split(" ", 2);

				boolean isDigit1 = Character.isDigit(id1[1].charAt(0));
				boolean isDigit2 = Character.isDigit(id2[1].charAt(0));

				// case 1). both logs are letter-logs
				if (!isDigit1 && !isDigit2) {
					// first compare the content
					int cmp = id1[1].compareTo(id2[1]);
					if (cmp != 0)
						return cmp;
					// logs of same content, compare the identifiers
					return id1[0].compareTo(id2[0]);
				}

				// case 2). one of logs is digit-log
				if (!isDigit1 && isDigit2)
					// the letter-log comes before digit-logs
					return -1;
				else if (isDigit1 && !isDigit2)
					return 1;
				else
					// case 3). both logs are digit-log
					return 0;
			}
		};

		Arrays.sort(logs, myComp);

		return logs;
	}

	public static void main(String[] args) {

		System.out.println(nthLargestElement(new int[] { 200, 500, 100, 200, 400 }, 5));

		String[] input = { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" };
		reorderLogFiles(input);

	}

}
