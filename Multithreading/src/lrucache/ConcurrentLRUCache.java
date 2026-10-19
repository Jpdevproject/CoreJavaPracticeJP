package lrucache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentLRUCache<K,V>{

    static class Node<K,V>{
        K key;
        V value;
        Node<K,V> prev;
        Node<K,V> next;

        Node(K key,V value){
            this.key=key;
            this.value=value;
        }

    }
    private Node<K,V> head;
    private Node<K,V> tail;
    private final int capacity;
    private final ConcurrentHashMap<K,Node<K,V>> cache;
    private final ReentrantLock lock=new ReentrantLock();


    public ConcurrentLRUCache(int capacity){
     if(capacity<=0)
         throw new IllegalArgumentException("Capacity can not be negative");
     this.capacity=capacity;
     this.cache=new ConcurrentHashMap<>();
    }

    public V get(K key){
        Node<K,V> node=cache.get(key);
        if(node==null)
            return null;
        lock.lock();
        try {
            moveToHead(node);
            return node.value;
        }finally {
            lock.unlock();
        }
    }

    private void moveToHead(Node<K,V> node) {
        if(node==head)
            return;
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(Node<K,V> node) {
        node.prev=null;
        node.next=head;
        if(head!=null){
            head.prev=node;
        }
        head=node;
        if(tail==null)
            tail=node;
    }

    private void removeNode(Node<K,V> node) {
        if(node.prev!=null){
            node.prev.next=node.next;
        }else{
            head=node.next;
        }

        if(node.next!=null){
            node.next.prev=node.prev;
        }else{
            tail=node.prev;
        }
    }

    public void put(K key,V value){
        lock.lock();
        try{
            Node<K,V> existing=cache.get(key);
            if(existing!=null){
                existing.value=value;
                moveToHead(existing);
                return;
            }
            Node<K,V> newNode=new Node<>(key,value);
            cache.put(key,newNode);
            addToHead(newNode);
            if(cache.size()>capacity){
                Node<K,V> lru=tail;
                removeNode(lru);
                cache.remove(lru.key);
            }
        }finally {
            lock.unlock();
        }
    }
    public int size(){
        return cache.size();
    }

    public void printCache(){
        lock.lock();
        try{
            Node<K,V> current=head;
            while (current!=null){
                System.out.println("["+current.key+"="+current.value+"="+"]");
                current=current.next;
            }

            System.out.println();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ConcurrentLRUCache<Integer, String> cache =
                new ConcurrentLRUCache<>(3);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");

        cache.printCache();

        cache.get(1);

        cache.printCache();

        cache.put(4, "D");

        cache.printCache();

        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }


}
