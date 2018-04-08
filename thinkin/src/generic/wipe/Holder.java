package generic.wipe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KaiLin.Guo on 2018-04-08.
 * 有界通配符 <？extends>，超类型通配符 <？super>，无界通配符 <？>
 */
public class Holder<T> {
    private T value;

    public Holder() {
    }

    public Holder(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        return value.equals(obj);
    }

    public static void main(String[] args) {
        Holder<Apple> appleHolder = new Holder<>(new Apple());
        Apple d = appleHolder.getValue();
        appleHolder.setValue(d);

        // Holder<Fruit> fruitHolder = appleHolder; // cannot upcast
        Holder<? extends Fruit> fruitHolder = appleHolder; //ok
        Fruit p = fruitHolder.getValue();
        d = (Apple) fruitHolder.getValue(); //return 'object'
        try {
            Orange c = (Orange) fruitHolder.getValue();
        } catch (Exception e) {
            System.out.println(e);
        }
        // fruitHolder.setValue(new Apple()); //cannot call set
        // fruitHolder.setValue(new Fruit()); //cannot call set
        System.out.println(fruitHolder.equals(d));


        // 逆变-超类型通配符
        List<? super Apple> apples = new ArrayList<>();
        apples.add(new Apple());
        apples.add(new Jonathan());
        // apples.add(new Fruit()); // error

    }
}

class Fruit {}

class Apple extends Fruit {}

class Jonathan extends Apple {}

class Orange extends Fruit {}
