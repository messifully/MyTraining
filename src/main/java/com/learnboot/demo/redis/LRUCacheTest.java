package com.learnboot.demo.redis;

import java.nio.channels.SocketChannel;
import java.util.*;

public class LRUCacheTest extends LinkedHashMap {

    public static void main(String[] args) {
        LRUCache1 map = new LRUCache1(4);
        map.put("1","a");
        map.put("2","a");
        map.put("3","a");
        map.put("4","a");
        map.put("5","a");





//        Iterator<Map.Entry> entries = map.entrySet().iterator();
//        while (entries.hasNext()) {
//            Map.Entry entry = entries.next();
//            System.out.println("Key = " + (String)entry.getKey() + ", Value = " + (String)entry.getValue());
//        }
//
//        for (Object key: map.keySet()) {
//            System.out.println("Key = " + (String)key + ", Value = " + (String)map.get(key));
//        }


    }



class LRUCache1 extends LinkedHashMap {

    private final int CACHE_SIZE;

    public LRUCache1(int cache_size) {
        super(cache_size, 0.75f, true);
        this.CACHE_SIZE = cache_size;
    }

    public int get(int key) {
        return (int) super.getOrDefault(key, -1);
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > CACHE_SIZE;
    }
}

/**
 * hashmap+queue实现
 */
class LRUCache2 {
    Map<Integer, Integer> map;
    Queue<Integer> queue;
    private final int CACHE_SIZE;
    int remain ;

    public LRUCache2(int CACHE_SIZE) {
        map = new HashMap<>();
        queue = new LinkedList<>();
        this.CACHE_SIZE = CACHE_SIZE;
        remain = CACHE_SIZE;
    }

    public int get(int key) {
        if (queue.contains(key)) {
            queue.remove(key);
            queue.add(key);
            return map.get(key);
        }
        return -1;
    }

    public void put (int key, int value) {
        //存在，更新队列，更新map
        if (queue.contains(key)) {
            //移除并加到队尾
            queue.remove(key);
            queue.add(key);
            //更新map
            map.put(key, value);
        }
        //不存在
        //如果未满，更新队列，更新map
        else if (remain > 0) {
            //添加队列
            queue.add(key);
            //添加map
            map.put(key,value);
            //调整可用数
            remain--;
        }
        //如果满了，清除队列头的key
        else {
            //清除头数据、清除map
            map.remove(queue.poll());
            //添加新数据
            queue.add(key);
            map.put(key,value);
        }

    }
}

