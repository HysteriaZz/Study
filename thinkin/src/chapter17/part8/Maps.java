package chapter17.part8;

import chapter17.part2.CountingMapData;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by KaiLin.Guo on 2018-04-17.
 * HashMap、、TreeMap、WeakHashMap、ConcurrentHashMap、IdentityHashMap
 * HashMap*：基于散列表的实现取代了HashTable，插入和查询的开销是固定的，可通过构造器设置容器和负载因子以调节容器性能
 * LinkedHashMap：类似于HashMap，按其插入顺序取的键值对，迭代访问时反而更快，因为它使用链表维护内部次序
 * TreeMap：基于红黑树的实现，【不允许键为null】，查看键或键值对时，会被排序（次序由Comparable或Comparator决定检索时根据树的遍历），唯一带有subMap方法的Map可以返回一个子树
 * WeakHashMap：弱键映射，允许释放所指向的对象，如果没有引用指向某个键，该键会被回收
 * ConcurrentHashMap：一种线程安全的Map，它不涉及同步加锁
 * IdentityHashMap：使用==代替equals对键进行散列的映射
 */
public class Maps {
    public static void printKeys(Map<Integer, String> map) {
        System.out.println("Size = " + map.size() + ", ");
        System.out.println("Keys: " + map.keySet());
    }

    public static void test(Map<Integer, String> map) {
        System.out.println(map.getClass().getSimpleName());
        map.putAll(new CountingMapData(25));
        map.putAll(new CountingMapData(25));
        printKeys(map);
        System.out.println("Values: " + map.values());
        System.out.println(map);
        System.out.println("map.containsKey(11): " + map.containsKey(11));
        System.out.println("map.get(11): " + map.get(11));
        System.out.println("map.containsValue(\"F0\"): " + map.containsValue("F0"));

        Integer key = map.keySet().iterator().next();
        System.out.println("First key in map: " + key);
        map.remove(key);
        printKeys(map);
        map.clear();
        System.out.println("map.isEmpty(): " + map.isEmpty());
        map.putAll(new CountingMapData(25));
        map.keySet().removeAll(map.keySet());
        System.out.println("map.isEmpty(): " + map.isEmpty() + "\n");

    }

    public static void main(String[] args) {
        test(new HashMap<>());
        test(new TreeMap<>());
        test(new LinkedHashMap<>());
        test(new IdentityHashMap<>());
        test(new ConcurrentHashMap<>());
        test(new WeakHashMap<>());

        // HashMap\LinkedHashMap\IdentityHashMap\ConcurrentHashMap\WeakHashMap允许key为空，TreeMap不允许，value都允许为空
        Map<Integer, String> map = new TreeMap<>();
        map.put(2, "A");
        map.put(1, "B");
        map.put(3, "C");
//        map.put(null, "2");
//        map.put(null, "1");
        System.out.println(map);
    }
}
