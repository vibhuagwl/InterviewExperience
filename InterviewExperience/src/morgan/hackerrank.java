package morgan;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class JavaTest2 {
	public void divide(int a, int b) {
		try {
			int c = a / b;
		} finally {
			System.out.println("Finally");
		}
	}
}

class Animal {

}

class Dog extends Animal {

}

class Labrador extends Dog

{

}

interface cal {
	void cal(int item);
}

class A implements cal {
	int x;

	public void cal(int item) {
		x = item * item;
	}
}

class B implements cal {
	int x;

	public void cal(int item) {
		x = item / item;
	}
}

class Color {
	private String name;

	public Color(String name) {
		this.name = name;
	}
}

public class hackerrank {

	static void printVal(Animal a) {
		System.out.println("ONE");

	}

	static void printVal(Dog a) {
		System.out.println("TWO");

	}

	static void printVal(Object a) {
		System.out.println("THREE");

	}

	int ival = 85;

	public hackerrank() {
		ival = 41;
	}

	{
		ival = 27;
	}

	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		a.x = 0;
		b.x = 0;
		a.cal(2);
		b.cal(2);
		System.out.println(a.x);
		System.out.println(b.x);
		Labrador labrador = new Labrador();
		printVal(labrador);
		hackerrank hackerrank = new hackerrank();
		System.out.println(hackerrank.ival);
		Integer number = 10;
		number++;
		assert number == null && number >= 0;
		System.out.println(number);

		Map<Color, String> map = new HashMap<>();
		map.put(new Color("Red"), "Red");
		map.put(new Color("Blue"), "Blue");
		map.put(new Color("Green"), "Green");
		System.out.println(map.get(new Color("Red")));

		JavaTest2 javaTest2 = new JavaTest2();
		try {
			javaTest2.divide(3, 0);

		} catch (RuntimeException e) {
			System.out.println("Run");
		} catch (Exception e) {
			System.out.println("Ex");
			// TODO: handle exception
		} finally {
			System.out.println("End");
		}
		System.out.println(Arrays.stream(new int[] { 1, 2, 3, 4, 5 }).filter(i -> i % 2 == 0).map(i -> i * 2).sum());
		// Set<? extends IOException> set = new HashSet<Exception>();
		Set<? extends IOException> set1 = new TreeSet<IOException>();
		Comparator<Integer> num = (num1, num2) -> num2.compareTo(num1);
		Integer[] i = new Integer[] { 1, 4, 3, 2 };
		Arrays.sort(i, num);
		for (Integer arr : i) {
			System.out.println(arr);

		}
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

			}
		};
	}

}
