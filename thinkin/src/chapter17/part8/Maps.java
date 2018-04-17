package chapter17.part8;

import chapter17.part2.CountingMapData;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by KaiLin.Guo on 2018-04-17.
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
