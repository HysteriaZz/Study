package chapter17.part9;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Created by KaiLin.Guo on 2018-04-19.
 * 实现一个简单的散列Map
 */
public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
    static final int SIZE = 997;
    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            buckets[index] = new LinkedList<>();
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
