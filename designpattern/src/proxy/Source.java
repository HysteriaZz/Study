package proxy;

/**
 * Created by KaiLin.Guo on 2017-11-28.
 */
public class Source implements Sourceable {
    @Override
    public void method() {
        System.out.println("the original method!");
    }
}
