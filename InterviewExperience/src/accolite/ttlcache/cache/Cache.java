/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accolite.ttlcache.cache;

import accolite.ttlcache.cache.controller.ICache;
import accolite.ttlcache.cache.factory.CacheFactory;
import accolite.ttlcache.cache.factory.CacheType;

/**
 *
 * @author Nikhil Karnwal
 */
public class Cache<K, V> {

    private static Cache mInstance = new Cache();

    private ICache<K,V> mCacheController;

    private Cache() {
        mCacheController = CacheFactory.<K, V>createCache(CacheType.TTLCache);
        mCacheController.init();
        mCacheController.setEvictionPeriod(5000);
        mCacheController.start();
    }

    public static Cache getInstance() {
        return mInstance;
    }
    
    public void put(K key, V value, long timeToLive){
        mCacheController.put(key, value, timeToLive);
    }

    public V get(K key){
        return mCacheController.get(key);
    }
    
    public long getExpireTime(K key){
        return mCacheController.getExpireTime(key);
    }
    
    public void delete(K key){
        mCacheController.delete(key);
    }
    
    public void deleteCache(){
        mCacheController.deleteCache();
    }
}
