package proxy;

/**
 * Created by KaiLin.Guo on 2017-11-30.
 */
public class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);
        // insert a proxy and call again
        Interface proxy = (Interface) java.lang.reflect.Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[] {Interface.class}, new DynamicProxyHandler(real));
        // proxy调用doSomething等方法时会使用代理的invoke方法
        consumer(proxy);
    }
}
