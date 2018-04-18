package chapter17.part8;

import chapter17.part2.CountingMapData;

import java.util.LinkedHashMap;

/**
 * Created by KaiLin.Guo on 2018-04-18.
 * LinkedHashMap可以认为是HashMap+LinkedList，即它既使用HashMap操作数据结构，又使用LinkedList维护插入元素的先后顺序
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>(new CountingMapData(9));
        System.out.println(linkedHashMap);
        // accessOrder = true 使用最近最少使用算法
        linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.putAll(new CountingMapData(9));
        System.out.println(linkedHashMap);
        for (int i = 0; i < 6; i++)
            linkedHashMap.get(i);
        System.out.println(linkedHashMap);
        linkedHashMap.get(0);
        System.out.println(linkedHashMap);

    }

}
