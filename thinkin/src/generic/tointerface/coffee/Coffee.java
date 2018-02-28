package generic.tointerface.coffee;

/**
 * Created by KaiLin.Guo on 2017-12-06.
 */
public class Coffee {

    private static long counter = 0;

    private final long id = counter++;

    public String toString() {
        return this.getClass().getSimpleName() + " " + id;
    }

}
