package osttra.strategy;

import osttra.cache.LFUCache;
import osttra.cache.LRUCache;
import osttra.cache.MFUCache;
import osttra.cache.MRUCache;

public class CacheSelectorMain {
	public static void main(String[] args) {

		// LFU Cache
		CacheContext cacheContext = new CacheContext(new LRUCache());
		cacheContext.putStrategy(1, 1);
		cacheContext.putStrategy(2, 2);
		cacheContext.getStrategy(2);
		cacheContext.putStrategy(3, 3);
		cacheContext.putStrategy(4, 4);
		cacheContext.putStrategy(5, 5);
		cacheContext.putStrategy(6, 6);
		cacheContext.getStrategy(2);
		cacheContext.putStrategy(7, 7);

		cacheContext = new CacheContext(new LFUCache());
		cacheContext.putStrategy(1, 1);
		cacheContext.putStrategy(2, 2);
		cacheContext.getStrategy(2);
		cacheContext.putStrategy(3, 3);
		cacheContext.putStrategy(4, 4);
		cacheContext.putStrategy(5, 5);
		cacheContext.putStrategy(6, 6);
		cacheContext.getStrategy(2);
		cacheContext.putStrategy(7, 7);
		
		
		cacheContext = new CacheContext(new MRUCache());
		cacheContext.putStrategy(1, 1);
		cacheContext.putStrategy(2, 2);
		cacheContext.getStrategy(2);
		cacheContext.putStrategy(3, 3);
		cacheContext.putStrategy(4, 4);
		cacheContext.putStrategy(5, 5);
		cacheContext.putStrategy(6, 6);
		cacheContext.getStrategy(2);
		cacheContext.putStrategy(7, 7);
		
		
		cacheContext = new CacheContext(new MFUCache());
		cacheContext.putStrategy(1, 1);
		cacheContext.putStrategy(2, 2);
		cacheContext.getStrategy(2);
		cacheContext.putStrategy(3, 3);
		cacheContext.putStrategy(4, 4);
		cacheContext.putStrategy(5, 5);
		cacheContext.putStrategy(6, 6);
		cacheContext.getStrategy(2);
		cacheContext.putStrategy(7, 7);
	}

}
