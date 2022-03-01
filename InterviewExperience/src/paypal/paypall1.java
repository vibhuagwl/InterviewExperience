package paypal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class PopulationCalculation

{
	int year;
	int birth;
	int death;

	public PopulationCalculation(int year, int birth, int death) {
		this.year = year;
		this.birth = birth;
		this.death = death;
	}

	public int getBirth() {
		return birth;
	}

	public int getDeath() {
		return death;
	}

	public int getYear() {
		return year;
	}

}

public class paypall1 {
	public static void main(String[] args) {

		List<PopulationCalculation> list = Arrays.asList(new PopulationCalculation(1898, 3, 1),
				new PopulationCalculation(1890, 1, 0), new PopulationCalculation(1988, 10, 4),
				new PopulationCalculation(1898, 4, 5), new PopulationCalculation(1905, 4, 2),
				new PopulationCalculation(1895, 0, 1), new PopulationCalculation(2000, 7, 3),
				new PopulationCalculation(1899, 3, 4));

		List<PopulationCalculation> sortedYearPopulation = list.stream()
				.sorted(Comparator.comparingInt(PopulationCalculation::getYear)).collect(Collectors.toList());

		int maxVal = Integer.MIN_VALUE;
		int maxYear = 0;
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < sortedYearPopulation.size(); i++) {
			int previousYearLiveCount = i >= 1 ? map.getOrDefault(sortedYearPopulation.get(i - 1).getYear(), 0) : 0;
			int mapVal = map.getOrDefault(sortedYearPopulation.get(i).getYear(), 0)
					+ (sortedYearPopulation.get(i).getBirth() - sortedYearPopulation.get(i).getDeath())
					+ previousYearLiveCount;
			map.put(sortedYearPopulation.get(i).getYear(), mapVal);
			if (maxVal < mapVal) {
				maxYear = sortedYearPopulation.get(i).getYear();
			}

		}
		System.out.println(maxYear);

	}

}
