package ezetap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class A {
	public static void a() {
		System.out.println("a");
	}
}

class B extends A {
	public static void a() {
		System.out.println("b");
	}
}

class TestClass {
	public static void main(String args[]) throws Exception {
		A a = new B();
		a.a();

		final String pig = "length:10";
		final String dog = "length: " + pig.length();
		System.out.println(pig == dog);
		BigInteger ft = new BigInteger("5000");
		BigInteger ft1 = new BigInteger("50000");
		BigInteger ft2 = new BigInteger("500000");
		BigInteger t = BigInteger.ZERO;
		t.add(ft);
		t.add(ft1);
		t.add(ft2);
		System.out.println(t);

		// BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
		List<Integer> res = twoSum(input, Integer.parseInt(br.readLine()));
		if (res.isEmpty()) {
			System.out.println(false);
		} else {
			System.out.println(true);
			System.out.println(res.get(0) + "," + res.get(1));
		}
	}

	public static List<Integer> twoSum(int[] arr, int target) {
		Arrays.sort(arr);
		int left = 0;
		int right = arr.length - 1;
		List<Integer> subres = new ArrayList<>();
		while (left < right) {
			if (left != 0 && arr[left] == arr[left - 1]) {
				left++;
				continue;
			}
			int sum = arr[left] + arr[right];
			if (sum == target) {

				subres.add(arr[left]);
				subres.add(arr[right]);
				left++;
				right--;
				return subres;
			} else if (sum > target) {
				right--;
			} else {
				left++;
			}
		}
		return subres;
	}
}
