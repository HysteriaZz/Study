package observer;

/**
 * Created by KaiLin.Guo on 2017-11-29.
 */
public class ObserverTest {
    public static void main(String[] args) {
        Subject subject = new MySubject();
        subject.add(new Observer1());
        subject.add(new Observer2());

        subject.operation();
    }
}
