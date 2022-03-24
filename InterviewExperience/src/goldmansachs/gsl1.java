package goldmansachs;

enum Direction {
	NORTH, SOUTH, EAST, WEST;
}

public class gsl1 {
	static void printRLE(String s) {
		for (int i = 0; i < s.length(); i++) {

			// Counting occurrences of s[i]
			int count = 1;
			while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
				i++;
				count++;
			}
			System.out.print(s.charAt(i) + "" + count + " ");
		}

		System.out.println();
	}

	public static void mergeArrays(int[] arr1, int[] arr2, int n1, int n2, int[] arr3) {
		int i = 0, j = 0, k = 0;
		while (i < n1 && j < n2) {
			if (arr1[i] < arr2[j])
				arr3[k++] = arr1[i++];
			else
				arr3[k++] = arr2[j++];
		}
		while (i < n1)
			arr3[k++] = arr1[i++];

		while (j < n2)
			arr3[k++] = arr2[j++];
	}

	public static boolean isRobotBounded(String instructions) {

		int x = 0, y = 0;
		Direction direction = Direction.NORTH;
		for (int i = 0; i < instructions.length(); i++) {
			char c = instructions.charAt(i);
			if (c == 'G') {
				if (direction == Direction.NORTH) {
					y += 1;
				} else if (direction == Direction.SOUTH) {
					y -= 1;
				} else if (direction == Direction.EAST) {
					x += 1;
				} else
					x -= 1;

			}

			else if (c == 'L') {
				if (direction == Direction.NORTH) {
					direction = Direction.WEST;
				} else if (direction == Direction.WEST) {
					direction = Direction.SOUTH;
				} else if (direction == Direction.SOUTH) {
					direction = Direction.EAST;
				} else if (direction == Direction.EAST) {
					direction = Direction.NORTH;
				}
			}

			else {
				if (direction == Direction.NORTH) {
					direction = Direction.EAST;
				} else if (direction == Direction.WEST) {
					direction = Direction.NORTH;
				} else if (direction == Direction.SOUTH) {
					direction = Direction.WEST;
				} else if (direction == Direction.EAST) {
					direction = Direction.SOUTH;
				}
			}

		}

		if (direction == Direction.NORTH && x == 0 && y == 0)
			return true;
		return direction != Direction.NORTH;
	}

	static int calcAngle(double h, double m) {
		// validate the input
		if (h < 0 || m < 0 || h > 12 || m > 60)
			System.out.println("Wrong input");

		if (h == 12)
			h = 0;
		if (m == 60) {
			m = 0;
			h += 1;
			if (h > 12)
				h = h - 12;
		}

		// Calculate the angles moved by hour and minute hands
		// with reference to 12:00
		int hour_angle = (int) (0.5 * (h * 60 + m));
		int minute_angle = (int) (6 * m);

		// Find the difference between two angles
		int angle = Math.abs(hour_angle - minute_angle);

		// smaller angle of two possible angles
		angle = Math.min(360 - angle, angle);

		return angle;
	}

	static double solution(String arg) {
		String[] hhmm = arg.split(":");
		double hh = Double.parseDouble(hhmm[0]);
		double mm = Double.parseDouble(hhmm[1]);
		if (hh < 0 || mm < 0 || hh > 12 || mm > 60)
			System.out.println("Wrong input");

		if (hh == 12)
			hh = 0;
		if (mm == 60) {
			mm = 0;
			hh += 1;
			if (hh > 12)
				hh = hh - 12;
		}
		hh = hh % 12;

		// find the position of the hour's hand
		int h = (int) ((hh * 360) / 12 + (mm * 360) / (12 * 60));

		// find the position of the minute's hand
		int m = (int) ((mm * 360) / (60));

		// calculate the angle difference
		int angle = Math.abs(h - m);

		// consider the shorter angle and return it
		if (angle > 180) {
			angle = 360 - angle;
		}
		return angle;

	}

	public static void main(String[] args) {
		String str = "15:00";
		System.out.println(solution(str));
		System.out.println(calcAngle(9, 60) + " degree");
		System.out.println(calcAngle(3, 30) + " degree");
		isRobotBounded("GGLLGG");
		int[] arr1 = { 1, 3, 5, 7 };
		int n1 = arr1.length;

		int[] arr2 = { 2, 4, 6, 8 };
		int n2 = arr2.length;

		int[] arr3 = new int[n1 + n2];

		mergeArrays(arr1, arr2, n1, n2, arr3);

		System.out.println("Array after merging");
		for (int i = 0; i < n1 + n2; i++)
			System.out.print(arr3[i] + " ");
	}
}
