package chapter17.part2;

import generic.tointerface.coffee.Generator;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by KaiLin.Guo on 2018-04-10.
 * 填充容器-适配器模式-collection生成器
 */
public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> gen, int quantity) {
        for (int i = 0; i < quantity; i++)
            add(gen.next());
    }

    public static <T> CollectionData<T> list(Generator<T> gen, int quantity) {
        return new CollectionData<T>(gen, quantity);
    }

    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>(new CollectionData<>(new Government(), 15));
        set.addAll(CollectionData.list(new Government(), 15));
        System.out.println(set);
    }

}

class Government implements Generator<String> {
    String[] foundation = ("strange women lying in ponds " +
    "distributing swords is no basis for a system of " + "government").split(" ");
    private int index;

    @Override
    public String next() {
        return foundation[index++];
    }
}
