package calsoft;

import java.util.stream.IntStream;

@FunctionalInterface
interface OddEvenInterface {

	public Integer add(int a, int b);
}

public class l1 implements OddEvenInterface {

	public static void main(String[] args) {
		IntStream stream = IntStream.of(2, 4, 2, 1);
		OddEvenInterface add = (x, y) -> x + y;
		l1 l1 = new l1();
		// int i = (a, b) -> a+b;

	}

	@Override
	public Integer add(int a, int b) {
		// TODO Auto-generated method stub
		return a + b;
	}

}
