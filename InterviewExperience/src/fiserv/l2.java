package fiserv;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Employee {

	private long id;
	private String name;
	private List<String> cars;
	private double salary;

	public Employee(long id, String name, List<String> cars, double salary) {
		this.id = id;
		this.name = name;
		this.cars = cars;
		this.salary = salary;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getCars() {
		return cars;
	}

	public void setCars(List<String> cars) {
		this.cars = cars;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", cars=" + cars + ", salary=" + salary + "]";
	}

	public static List<Employee> getEmployeeList() {
		List<Employee> list = Arrays.asList(new Employee(1, "A", Arrays.asList("Hyundai", "Kia", "Maruti"), 1000),
				new Employee(2, "B", Arrays.asList("Jeep", "Honda", "Maruti"), 2000),
				new Employee(3, "C", Arrays.asList("Honda", "Tata", "Nissan"), 2000),
				new Employee(3, "C", Arrays.asList("Honda", "Tata", "Nissan"), 2000));

		return list;

	};

}

public class l2 {
	public static void main(String[] args) {

		List<Employee> empList = Employee.getEmployeeList();
		empList.stream().filter(emp -> emp.getCars().contains("Maruti")).forEach(System.out::println);
		System.out.println("---");

		empList.stream().forEach(System.out::println);
		distinctList(empList, Employee::getCars).forEach(System.out::println);
	}

	public static <T> List<T> distinctList(List<T> list, Function<? super T, ?>... keyExtractors) {

		return list.stream().filter(distinctByKeys(keyExtractors)).collect(Collectors.toList());
	}

	private static <T> Predicate<T> distinctByKeys(Function<? super T, ?>... keyExtractors) {

		final Map<List<?>, Boolean> seen = new ConcurrentHashMap();

		return t -> {

			final List<?> keys = Arrays.stream(keyExtractors).map(ke -> ke.apply(t)).collect(Collectors.toList());

			return seen.putIfAbsent(keys, Boolean.TRUE) == null;

		};

	}

}
