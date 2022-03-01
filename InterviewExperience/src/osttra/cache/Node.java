package osttra.cache;

public class Node {

	private Node previous;
	private Node next;
	public int key;
	public int value;
	int frequency;

	/**
	 * Default Constructor
	 */
	public Node() {
	}

	public Node(int capacity) {

	}

	public Node(int k, int v, int frequency) {
		this.key = k;
		this.value = v;
		this.frequency = frequency;
	}

	/**
	 * Parameterized Constructor
	 * 
	 * @param previous
	 * @param next
	 * @param key
	 * @param value
	 */
	public Node(Node previous, Node next, int key, int value) {
		this.previous = previous;
		this.next = next;
		this.key = key;
		this.value = value;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}