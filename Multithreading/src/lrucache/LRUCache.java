package lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache <K,V>{
    private final int capacity;
    private final Map<K,V> cache;

    public LRUCache(int capacity){
        if(capacity<=0)
            throw new IllegalArgumentException("Capacity can not be negative");
        this.capacity=capacity;
        this.cache=new LinkedHashMap<K,V>(capacity,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size()>LRUCache.this.capacity;
            }
        };
    }
    public synchronized V get(K key){
        return cache.get(key);
    }

    public synchronized int size(){
        return cache.size();
    }
    public synchronized void put(K key,V value){
        cache.put(key,value);
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");

        System.out.println("Size: " + cache.size()); // 3

        // Access 1, making it recently used
       // cache.get(1);

        // Adding 4 should evict 2
        cache.put(4, "D");

        System.out.println("1 = " + cache.get(1)); // A
        System.out.println("2 = " + cache.get(2)); // null (evicted)
        System.out.println("3 = " + cache.get(3)); // C
        System.out.println("4 = " + cache.get(4)); // D
    }


}
