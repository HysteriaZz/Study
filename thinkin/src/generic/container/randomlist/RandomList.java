package generic.container.randomlist;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by KaiLin.Guo on 2018-02-28.
 */
public class RandomList<T> {
    private ArrayList<T> storage = new ArrayList<T>();

    private Random random = new Random(47);

    public void add(T item) {
        storage.add(item);
    }

    public T select() {
        return storage.get(random.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<>();
        for (String s : ("The quick brown fox jumped over " + "the lazy brown dog").split(" "))
            rs.add(s);
        for (int i = 0; i < 11; i++)
            System.out.print(rs.select() + " ");
    }

}
