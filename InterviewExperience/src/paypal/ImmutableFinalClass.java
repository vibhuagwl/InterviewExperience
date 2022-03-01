package paypal;

class Immutable {
	private final int value;

	public Immutable(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}

public class ImmutableFinalClass extends Immutable {
	private int realValue;

	public ImmutableFinalClass(int value) {
		super(value);

		realValue = value;
	}

	public int getValue() {
		return realValue;
	}

	public void setValue(int newValue) {
		realValue = newValue;
	}

	public static void main(String[] arg) {
		ImmutableFinalClass obj = new ImmutableFinalClass(4);
		Immutable immObj = (Immutable) obj;
		System.out.println(immObj.getValue());
		obj.setValue(8);
		System.out.println(immObj.getValue());
	}
}