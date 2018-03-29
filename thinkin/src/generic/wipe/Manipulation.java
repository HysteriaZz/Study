package generic.wipe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KaiLin.Guo on 2018-03-29.
 * 泛型的类型参数T被擦除 ，将擦除到它的第一个边界
 *
 */
public class Manipulation {
    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<HasF>(hf);
        manipulator.manipulate();

        System.out.println("1".getClass());
        ArrayList<String> ll = new ArrayList<>();
        List<String> kk = new ArrayList<>();
        System.out.println(new ArrayList<Integer>().getClass());
        System.out.println(ll.getClass());
        System.out.println(kk.getClass());

//        class java.lang.String
//        class java.util.ArrayList
//        class java.util.ArrayList
//        class java.util.ArrayList

    }
}

class Manipulator<T> {
    private T obj;

    public Manipulator(T x) {
        obj = x;
    }

    public void manipulate() {
        // 编译报错，类型被擦除
//        obj.f();
    }
}

class Manipulator2<T extends HasF> {
    private T obj;

    public Manipulator2(T x) {
        obj = x;
    }

    public void manipulate() {
        obj.f();
    }
}

class HasF {
    public void f() {
        System.out.println("HasF.f()");
    }
}
