package observer;

/**
 * Created by KaiLin.Guo on 2017-11-29.
 */
public class MySubject extends AbstractSubject {
    @Override
    public void operation() {
        System.out.println("update self!");
        notifyObservers();
    }
}
