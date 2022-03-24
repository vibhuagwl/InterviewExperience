package epam;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class l1 {

	public static void main(String[] args) {
		String input = "Jim went Went To to to school went to";
		StringBuffer sb = new StringBuffer();
		String[] split = input.split(" ");
		for (int i = 0; i < split.length; i++) {
			if (sb.toString().toLowerCase().indexOf(split[i].toLowerCase()) < 0)
				sb.append(split[i]);
		}
		System.out.println(sb.toString());

		ArrayList<String> arr = new ArrayList<>();
		for (int i = 0; i < split.length; i++) {
			String str = split[i];
			if (arr.stream().filter(e -> e.equalsIgnoreCase(str)).collect(Collectors.toList()).size() == 0) {
				arr.add(split[i]);
			}

		}
		arr.stream().forEach(System.out::println);
		System.out.println();
		for (int i = 0; i < split.length; i++) {
			if (!arr.stream().anyMatch(split[i]::equalsIgnoreCase)) {
				arr.add(split[i]);
			}
		}

		arr.stream().forEach(System.out::println);
	}

}
