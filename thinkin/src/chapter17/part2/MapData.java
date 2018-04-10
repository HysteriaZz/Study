package chapter17.part2;

import generic.tointerface.coffee.Generator;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Created by KaiLin.Guo on 2018-04-10.
 * 填充容器-适配器模式-map生成器
 */
public class MapData<K, V> extends LinkedHashMap<K, V> {

    /**
     * a single pair generator
     * @param gen
     * @param quantity
     */
    public MapData(Generator<Pair<K, V>> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Pair<K, V> p = gen.next();
            put(p.key, p.value);
        }
    }

    /**
     * an iterable and a value generator
     * @param genK
     * @param genV
     */
    public MapData(Iterable<K> genK, Generator<V> genV) {
        for (K key : genK)
            put(key, genV.next());
    }

    public static void main(String[] args) {
        LinkedHashMap<Integer, String> lk = new MapData<>(new Letters(), 11);
        LinkedHashMap<Integer, String> lp = new MapData<>(new Letters(), new RandStr());
        
        System.out.println(lk);
        System.out.println(lp);
    }
}

class Letters implements Generator<Pair<Integer, String>>, Iterable<Integer> {
    private int size = 9;
    private int number = 1;
    private char letter = 'A';

    @Override
    public Pair<Integer, String> next() {
        return new Pair<>(number++, "" + letter++);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return number < size;
            }

            @Override
            public Integer next() {
                return number++;
            }
        };
    }
}

class RandStr implements Generator<String> {
    private int i  = 1;

    @Override
    public String next() {
        return  "Str" + i++;
    }
}
