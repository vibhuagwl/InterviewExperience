package osttra.cache;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

import osttra.strategy.CacheStrategy;

public class MFUCache implements CacheStrategy {

	private final Map<Integer, Node> cache;
	private final LinkedHashSet[] frequencyList;
	private int hightestFrequency;
	private int maxFrequency;

	private final int maxCacheSize;
	private final float evictionFactor;
	
	

	public MFUCache() {
		this.cache = null;
		this.frequencyList = null;
		this.maxCacheSize = 0;
		this.evictionFactor = 0;
	}

	public MFUCache(int maxCacheSize, float evictionFactor) {
		this.cache = new HashMap<>();
		this.frequencyList = new LinkedHashSet[maxCacheSize];
		this.hightestFrequency = 0;
		this.maxFrequency = maxCacheSize - 1;
		this.maxCacheSize = maxCacheSize;
		this.evictionFactor = evictionFactor;
		initFrequencyList();
	}

	public void put(int key, int value) {
		int oldValue = 0;
		Node currentNode = cache.get(key);
		if (currentNode == null) {
			if (cache.size() == maxCacheSize) {
				doEviction();
			}
			LinkedHashSet<Node> nodes = frequencyList[0];
			currentNode = new Node(key, value, 0);
			nodes.add(currentNode);
			cache.put(key, currentNode);
		} else {
			oldValue = currentNode.value;
			currentNode.key = value;
		}

	}

	public int get(int key) {
		Node currentNode = cache.get(key);
		if (currentNode != null) {
			int currentFrequency = currentNode.frequency;
			if (currentFrequency < maxFrequency) {
				int nextFrequency = currentFrequency + 1;
				LinkedHashSet<Node> currentNodes = frequencyList[currentFrequency];
				LinkedHashSet<Node> newNodes = frequencyList[nextFrequency];
				moveToNextFrequency(currentNode, nextFrequency, currentNodes, newNodes);
				cache.put((Integer) key, currentNode);

				if (hightestFrequency < nextFrequency) {
					hightestFrequency = nextFrequency;
				}
			} else {
				// Hybrid with MRU: put most recently accessed ahead of others:
				LinkedHashSet<Node> nodes = frequencyList[currentFrequency];
				nodes.remove(currentNode);
				nodes.add(currentNode);
			}
			return currentNode.value;
		} else {
			return 0;
		}
	}

	public Integer remove(int key) {
		Node currentNode = cache.remove(key);
		if (currentNode != null) {
			LinkedHashSet<Node> nodes = frequencyList[currentNode.frequency];
			nodes.remove(currentNode);
			if (hightestFrequency == currentNode.frequency) {
				findNextMostFrequency();
			}
			return currentNode.value;
		} else {
			return null;
		}
	}

	public int frequencyOf(Integer k) {
		Node node = cache.get(k);
		if (node != null) {
			return node.frequency + 1;
		} else {
			return 0;
		}
	}

	public void clear() {
		for (int i = 0; i <= maxFrequency; i++) {
			frequencyList[i].clear();
		}
		cache.clear();
		hightestFrequency = 0;
	}

	public int size() {
		return cache.size();
	}

	public boolean isEmpty() {
		return this.cache.isEmpty();
	}

	public boolean containsKey(Object o) {
		return this.cache.containsKey(o);
	}

	public boolean containsValue(Object o) {
		return false; // To change body of implemented methods use File |
						// Settings | File Templates.
	}

	private void initFrequencyList() {
		for (int i = 0; i <= maxFrequency; i++) {
			frequencyList[i] = new LinkedHashSet<Node>();
		}
	}

	private void doEviction() {
		int currentlyDeleted = 0;
		float target = maxCacheSize * evictionFactor;
		while (currentlyDeleted < target) {
			LinkedHashSet<Node> nodes = frequencyList[hightestFrequency];
			if (nodes.isEmpty()) {
				throw new IllegalStateException("The most frequency constraint violated!");
			} else {
				Iterator<Node> it = nodes.iterator();
				while (it.hasNext() && currentlyDeleted++ < target) {
					Node node = it.next();
					it.remove();
					cache.remove(node.key);
				}
				if (!it.hasNext()) {
					findNextMostFrequency();
				}
			}
		}
	}

	private void moveToNextFrequency(Node currentNode, int nextFrequency, LinkedHashSet<Node> currentNodes,
			LinkedHashSet<Node> newNodes) {
		currentNodes.remove(currentNode);
		newNodes.add(currentNode);
		currentNode.frequency = nextFrequency;
	}

	private void findNextMostFrequency() {
		while (hightestFrequency <= maxFrequency && frequencyList[hightestFrequency].isEmpty()) {
			--hightestFrequency;
		}
		if (hightestFrequency < 0) {
			hightestFrequency = 0;
		}
	}

	public String printKey() {
		final StringBuilder sb = new StringBuilder("");

		for (java.util.Map.Entry<Integer, Node> entry : cache.entrySet()) {
			sb.append(entry.getKey()).append(", ");
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		return "MFUCache [cache=" + cache + ", frequencyList=" + Arrays.toString(frequencyList) + ", hightestFrequency="
				+ hightestFrequency + ", maxFrequency=" + maxFrequency + ", maxCacheSize=" + maxCacheSize + "]";
	}
}
