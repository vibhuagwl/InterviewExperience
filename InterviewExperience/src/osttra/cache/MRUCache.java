package osttra.cache;

import java.util.HashMap;

import osttra.strategy.CacheStrategy;

public class MRUCache implements CacheStrategy {

	/**
	 * HashMap for cache
	 */
	private HashMap<Integer, Node> cache = new HashMap<>();

	/**
	 * Nodes for head and tail
	 */
	private Node head, tail;

	/**
	 * Capacity of cache
	 */
	private int capacity;

	/**
	 * Default capacity of cache
	 */
	private static final int DEFAULT_CAPACITY = 100;

	/**
	 * Default Constructor
	 */
	public MRUCache() {
		setCapacity(DEFAULT_CAPACITY);
	}

	/**
	 * Parameterized Constructor
	 * 
	 * @param capacity
	 */
	public MRUCache(int capacity) {
		setCapacity(capacity);
	}

	/**
	 * Method to get the value associated with key from cache
	 * 
	 * @param key
	 * @return {@link V}
	 */
	public int get(int key) {
		/* If cache does not contains key, return null */
		if (!cache.containsKey(key)) {
			return -1;
		}
		/* If key exists, get the key and return the value */
		Node node = cache.get(key);
		/*
		 * Since this node is least recently used now, move it to the end. When eviction
		 * will happen, this will be the last entry to be removed. Removal will happen
		 * at tail.
		 */
		moveNodeToLast(node);
		return node.getValue();
	}

	/**
	 * Method to add the key value pair to cache
	 * 
	 * @param key
	 * @param value
	 */
	public void put(int key, int value) {
		/*
		 * If cache contains the key, find that key value pair, Since this is a map and
		 * only key is same. Value can be different. Replace this current value and push
		 * this node to end as we have accessed it already
		 */
		if (cache.containsKey(key)) {
			Node existing = cache.get(key);
			existing.setValue(value);
			moveNodeToLast(existing);
			return;
		}
		/*
		 * If cache has reached the capacity, evict the MRU node and remove it from
		 * cache
		 */
		Node newNode;
		if (cache.size() == capacity) {
			newNode = evict();
			cache.remove(newNode.getKey());
		} else {
			newNode = new Node();
		}
		/*
		 * Create this new node, set key and values. Add this node to appropriate place
		 * and put in cache
		 */
		newNode.setKey(key);
		newNode.setValue(value);
		addNewNode(newNode);
		cache.put(key, newNode);
	}

	/**
	 * Method to set capacity for cache
	 * 
	 * @param capacity
	 */
	public void setCapacity(int capacity) {
		/* Check if capacity is valid */
		checkCapacity(capacity);
		/*
		 * Now, start from the end and begin evicting until we meet the new capacity.
		 * Remove entries from cache as well
		 */
		for (int i = cache.size(); i > capacity; i--) {
			Node evicted = evict();
			cache.remove(evicted.getKey());
		}
		this.capacity = capacity;
	}

	/**
	 * Method to check the size of cache
	 * 
	 * @return {@link int}
	 */
	public int size() {
		return cache.size();
	}

	/**
	 * Method to get the capacity of cache
	 * 
	 * @return {@link int}
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Method to add a new node
	 * 
	 * @param node
	 */
	private void addNewNode(Node node) {
		/*
		 * If cache is empty, both head and tail points to same new node
		 */
		if (cache.isEmpty()) {
			head = tail = node;
			return;
		}
		/*
		 * Else, append the new node to tail and update the position of tail
		 */
		tail.setNext(node);
		node.setPrevious(tail);
		node.setNext(null);
		tail = node;
	}

	/**
	 * Method to evict the entry from cache
	 * 
	 * @return {@link Node}
	 */
	private Node evict() {
		/* If cache is empty, nothing to evict */
		if (head == null) {
			throw new AssertionError("Cannot evict from an empty cache!!");
		}
		/* Evict the tail, update next and evicted node */
		Node evicted = tail;
		tail = evicted.getPrevious();
		tail.setNext(null);
		evicted.setNext(null);
		return evicted;
	}

	/**
	 * Method to check capacity
	 * 
	 * @param capacity
	 */
	private void checkCapacity(int capacity) {
		/* Invalid capacity if less then 0 */
		if (capacity <= 0) {
			throw new IllegalArgumentException("Invalid Capacity. Should be positive!!");
		}
	}

	/**
	 * Method to move node to last
	 * 
	 * @param node
	 */
	private void moveNodeToLast(Node node) {
		/* If node is already at last, nothing to process */
		if (tail == node) {
			return;
		}
		/* Update previous and next nodes */
		Node previous = node.getPrevious();
		Node next = node.getNext();
		if (previous != null) {
			previous.setNext(next);
		}
		if (next != null) {
			next.setPrevious(previous);
		}
		/* Update head and tail position */
		if (head == node) {
			head = next;
		}
		tail.setNext(node);
		node.setPrevious(tail);
		node.setNext(null);
		tail = node;
	}

	public static void main(String[] args) {
		MRUCache cache = new MRUCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(2);
		cache.put(3, 3);
		cache.put(4, 4);
		cache.put(5, 5);
		cache.put(6, 6);

		cache.get(2);
		cache.put(7, 7);

	}

}
