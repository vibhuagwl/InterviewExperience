package osttra.strategy;

public interface CacheStrategy {

	public void put(int Key, int value);

	public int get(int key);

}
