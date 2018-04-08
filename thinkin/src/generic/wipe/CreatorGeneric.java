package generic.wipe;

/**
 * Created by KaiLin.Guo on 2018-03-30.
 */
public class CreatorGeneric {
    public static void main(String[] args) {
        Creator c = new Creator();
        c.f();
    }
}

abstract class GenericWithCreate<T> {
    final T element;

    public GenericWithCreate() {
        element = create();
    }

    abstract T create();
}

class X {}

class Creator extends GenericWithCreate<X> {
    @Override
    X create() {
        return new X();
    }

    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}
