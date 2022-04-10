package pubmatic;

class C {
}

class D extends C {
}

class A {

	public String name = "A";

	public static void foo() {
		System.out.println("foo from class A");
	}

	public void hi() {
		System.out.println("hi from class A");
		hello();
	}

	public void hello() {
		System.out.println("hello from class A");

	}

}

class B extends A {
	public String name = "B";

	public static void foo() {
		System.out.println("foo from class B");
	}

	public void hi() {
		super.hi();
		System.out.println("hi from class B");

	}

	public void hello() {
		System.out.println("hello from class B");
	}
}

class Person {
	private final String name;
	private final Integer age;
	public static String schoolName;

	public Person(String name, Integer age, String schoolName) {
		this.name = name;
		this.age = age;
		this.schoolName = schoolName;
	}

	public static String getSchoolName() {
		return schoolName;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	// getter methods
}

public class l1 {

	public static void reverseDigits(int i) {

		int reverse = 0;
		while (i != 0) {
			int rem = i % 10;
			reverse = reverse * 10 + rem;
			i = i / 10;
		}

	}

	public static void main(String[] args) {
		reverseDigits(1234);
		Person p1 = new Person("b", 2,"pschool1");
		System.out.println(p1.getSchoolName());
		Person p = new Person("a", 1,"pschool");
		System.out.println(p.getSchoolName());
		A b = new B();
		b.hi();
	}

}
