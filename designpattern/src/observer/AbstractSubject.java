package observer;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by KaiLin.Guo on 2017-11-29.
 */
public abstract class AbstractSubject implements Subject {

    private Vector<Observer> vector = new Vector<Observer>();

    @Override
    public void add(Observer observer) {
        vector.add(observer);
    }

    @Override
    public void del(Observer observer) {
        vector.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Enumeration<Observer> enums = vector.elements();
        while(enums.hasMoreElements()){
            enums.nextElement().update();
        }
    }
}
