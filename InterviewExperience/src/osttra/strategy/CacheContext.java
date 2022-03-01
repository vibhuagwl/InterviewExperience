package osttra.strategy;

public class CacheContext {

	private CacheStrategy strategy;

	public CacheContext(CacheStrategy strategy) {
		this.strategy = strategy;
	}

	public void putStrategy(int key, int value) {
		strategy.put(key, value);
	}
	
	public void getStrategy(int key) {
		strategy.get(key);
	}
}
