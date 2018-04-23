package other;

/**
 * Created by KaiLin.Guo on 2018-04-09.
 */
public class Cx {

}

interface A {
    void f();
    void g();
}

class C implements A {
    @Override
    public void f() {

    }

    @Override
    public void g() {

    }
}

/**
 * 若父类实现的接口，子类可以不实现接口
 */
class D extends C implements A {

}

/**
 * 抽象类可以不实现接口的所有方法
 */
abstract class E implements A {
    public void f(){

    }
}

/**
 * 抽象类可以不含抽象方法，但不能实例化
 */
abstract class F {
    void t() {

    }
}
