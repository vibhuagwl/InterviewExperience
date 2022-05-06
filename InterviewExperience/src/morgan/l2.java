package morgan;

import java.util.ArrayList;
import java.util.List;

class AB {

}

class BA {

}

public class l2 {

	static void substring(String str, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				System.out.print(str.substring(i, j));
			}
		}
	}

	public static void main(String[] args) {
		List l = new ArrayList<>();
		l.add(new AB());
		l.add(new BA());
		l.get(0);

	}
}
