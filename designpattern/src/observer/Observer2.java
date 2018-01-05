package observer;

/**
 * Created by KaiLin.Guo on 2017-11-29.
 */
public class Observer2 implements Observer {

    @Override
    public void update() {
        System.out.println("observer2 has received!");
    }
}
