package com.w.cn.HashMap;

/**
 * @author wencheng
 * @description
 * @email 2515106327@qq.com
 * @create 2020-03-10-14:37
 *
 * jdk 1.7 以下  都是数组+链表
 * 链表都是在头节点的位置添加元素   插入最快，然后将新插入的节点 作为数据角标位置元素
 *
 * ref https://www.ixigua.com/pseries/6802120507492663821_6802093172378829326/?logTag=yKWWub-pyorg0-lMwpCWa
 */
public class MyHashMap7<K,V> {
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
    int sizeCount = 0;
    private Entry [] table;

    public MyHashMap7(Entry[] table) {
        this.table = new Entry[DEFAULT_INITIAL_CAPACITY]; //构造方法 初始化 链表数据
    }

    static final int index(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16)%DEFAULT_INITIAL_CAPACITY;
    }
    public int size(){
        return sizeCount;
    }

    public Object put(K key,V value){
        int i = index(key);
        addEntry(new Entry(key, value, table[i]), i);
        return null;
    }

    private void addEntry(Entry entry1, int i) {
        Entry entry = entry1;
        table[i] = entry;
    }

    public Object get(Object key){
        return null;
    }

    class Entry<K,V>{
        private V v;
        private K k;
        private Entry<K,V> next;

        public Entry(V v, K k, Entry<K, V> next) {
            this.v = v;
            this.k = k;
            this.next = next;
        }
    }

}
