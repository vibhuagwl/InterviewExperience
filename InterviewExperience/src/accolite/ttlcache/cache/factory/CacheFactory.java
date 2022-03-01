/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accolite.ttlcache.cache.factory;

import accolite.ttlcache.cache.controller.ICache;
import accolite.ttlcache.cache.controller.TTLCache;

/**
 *
 * @author Nikhil Karnwal
 */
public class CacheFactory<K, V> {
    public static <K, V> ICache<K, V> createCache(CacheType cacheType){
        ICache<K, V> cache = null;
        switch(cacheType){
            case TTLCache:
                cache = new TTLCache<K, V>();
                break;
            default:
                cache = new TTLCache<K, V>();
        }
        return cache;
    }
}
