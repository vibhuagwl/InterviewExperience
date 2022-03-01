package paypal;

interface Interface1 {
	default void myDefaultMethod() {
		System.out.println("Interface One default method");
	}
}

interface Interface2 {
	default void myDefaultMethod() {
		System.out.println("Interface Two default method");
	}
}

public class InterfaceAmbiguity implements Interface1, Interface2 {

	public static void main(String[] args) {
		InterfaceAmbiguity implClass = new InterfaceAmbiguity();
		implClass.myDefaultMethod();
	}

	@Override
	public void myDefaultMethod() {
		// TODO Auto-generated method stub
		Interface1.super.myDefaultMethod();
	}

}
