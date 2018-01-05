package proxy;

/**
 * Created by KaiLin.Guo on 2017-11-28.
 */
public class ProxyTest {

    public static void main(String[] args) {
        // 原有方法
        Sourceable sourceable = new Source();
        sourceable.method();

        // 使用代理进行拓展，不改变之前方法
        sourceable = new Proxy();
        sourceable.method();
    }
}
