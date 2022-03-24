package paypal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.math.BigDecimal;

class Person {
	public Person(Integer id, String fname, String lname) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
	}

	private Integer id;
	private String fname;
	private String lname;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", fname=" + fname + ", lname=" + lname + "]";
	}
}

class Employee {
	private int id;
	private String name;
	private String designation;
	private String gender;
	private long salary;
	private int age;

	public Employee(int id, String name, String designation, String gender, long salary) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.gender = gender;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + ", gender=" + gender
				+ ", salary=" + salary + "]";
	}
}

class Staff {

	private String name;
	private int age;
	private BigDecimal salary;

	public Staff() {
		// TODO Auto-generated constructor stub
	}

	public Staff(String name, int age, BigDecimal salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

}

class StaffPublic {

	private String name;
	private int age;
	private String extra;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

}

class StatisticsUtility {
	public static int addIntData(int num1, int num2) {
		return num1 + num2;
	}
}

public class Paypall2 {

	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
		Map<Object, Boolean> seen = new ConcurrentHashMap<>();
		return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

	public static void main(String[] args) {
		long[][] data = { { 1L, 2L }, { 3L, 4L }, { 5L, 6L } };
		LongStream ls1 = Arrays.stream(data).flatMapToLong(row -> Arrays.stream(row));

		System.out.println(ls1.sum());

		List<Employee> employeesList = new ArrayList<>();

		employeesList.add(new Employee(101, "Glady", "Manager", "Male", 25_00_000));
		employeesList.add(new Employee(102, "Vlad", "Software Engineer", "Female", 15_00_000));
		employeesList.add(new Employee(103, "Shine", "Lead Engineer", "Female", 20_00_000));
		employeesList.add(new Employee(104, "Nike", "Manager", "Female", 25_00_000));
		employeesList.add(new Employee(105, "Slagan", "Software Engineer", "Male", 15_00_000));
		employeesList.add(new Employee(106, "Murekan", "Software Engineer", "Male", 15_00_000));
		employeesList.add(new Employee(107, "Gagy", "Software Engineer", "Male", 15_00_000));
		Comparator<Employee> empNameComparator = Comparator.comparing(Employee::getName)
				.thenComparing(Employee::getAge);
		Collections.sort(employeesList, empNameComparator);
		employeesList.forEach(System.out::println);
		Stream<Integer> s = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		// group by - multiple fields
		// Grouping by designation and Gender two properties and need to get the count.

		Map<String, Map<String, Long>> multipleFieldsMap = employeesList.stream().collect(Collectors.groupingBy(
				Employee::getDesignation, Collectors.groupingBy(Employee::getGender, Collectors.counting())));
		Map<String, Map<String, List<Employee>>> multipleFieldsMapList = employeesList.stream()
				.collect(Collectors.groupingBy(Employee::getDesignation, Collectors.groupingBy(Employee::getGender)));

		// printing the count based on the designation and gender.
		System.out.println("Group by on multiple properties" + multipleFieldsMap);

		Map<Integer, String> hmap = new HashMap();
		hmap.put(11, "Apple");
		hmap.put(22, "Orange");
		hmap.put(33, "Kiwi");
		hmap.put(44, "Banana");

		// filter
		hmap.entrySet().stream().filter(map -> map.getKey().intValue() <= 22)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		hmap.entrySet().stream().filter(map -> map.getValue().equals("Orange"))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		hmap.entrySet().stream().filter(map -> map.getKey().intValue() <= 22)
				.filter(map -> map.getValue().startsWith("A"))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		hmap.values().stream().anyMatch(v -> v.equalsIgnoreCase("Orrange"));
		// max
		hmap.entrySet().stream().max((entry1, entry2) -> entry1.getKey() > entry2.getKey() ? 1 : -1).get().getKey();

		// sort
		Map<String, Map<String, List<String>>> mapOfList = new HashMap<>();
		Map<String, Map<String, List<String>>> collect = mapOfList.entrySet().stream()
				.sorted(Map.Entry.comparingByKey()).collect(
						Collectors.toMap(
								Map.Entry::getKey, e -> e.getValue().entrySet().stream()
										.sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey,
												Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new)),
								(a, b) -> a, LinkedHashMap::new));

		int[] array = { 23, 43, 56, 97, 32 };
		Arrays.stream(array).reduce((x, y) -> x + y).ifPresent(System.out::print);
		Arrays.stream(array).reduce(Integer::sum).ifPresent(System.out::print);
		Arrays.stream(array).reduce(StatisticsUtility::addIntData);

		Person lokeshOne = new Person(1, "Lokesh", "Gupta");
		Person lokeshTwo = new Person(2, "Lokesh", "Gupta");
		Person lokeshThree = new Person(3, "Lokesh", "Gupta");
		Person brianOne = new Person(4, "Brian", "Clooney");
		Person brianTwo = new Person(5, "Brian", "Clooney");
		Person alex = new Person(6, "Alex", "Kolen");

		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
		IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println(stats.getMax());
		System.out.println(stats.getMin());
		Collection<Person> list = Arrays.asList(alex, brianOne, brianTwo, lokeshOne, lokeshTwo, lokeshThree);

		List<Person> personListFiltered = list.stream().filter(distinctByKey(p -> p.getFname()))
				.collect(Collectors.toList());

		list.stream().map(p -> p.getFname()).collect(Collectors.toList());

		ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));
		numbersList.stream().collect(Collectors.toMap(Function.identity(), v -> 1l, Long::sum));

		lengthGreaterThan(Arrays.asList("vibhu", "agarwal", "neelam", "ram", "kk"), 3).forEach(System.out::print);
		List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
		List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);

		num.stream().map(n -> n * 2).collect(Collectors.toList());
		List<Staff> staff = Arrays.asList(new Staff("mkyong", 30, new BigDecimal(10000)),
				new Staff("jack", 27, new BigDecimal(20000)), new Staff("lawrence", 33, new BigDecimal(30000)));

		staff.stream().map(temp -> {
			StaffPublic sp = new StaffPublic();
			sp.setName(temp.getName());
			sp.setAge(temp.getAge());
			if ("mkyong".equals(temp.getName())) {
				sp.setExtra("this field is for mkyong only");

			}
			return sp;
		}).collect(Collectors.toList());

		String prefix = "";
		List<String> item = new ArrayList<>();
		item.stream().filter(e -> (!e.startsWith(prefix))).collect(Collectors.toList());

		Map<String, Long> result = items.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(result);
	}

	static List<String> lengthGreaterThan(List<String> names, int length) {
		return names.stream().filter(e -> e.length() > length).collect(Collectors.toList());
		// Use Stream APIs here
	}

	Map<String, Long> groupByCount(List<String> colors) {
		// Use Stream APIs here
		return colors.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}

}
