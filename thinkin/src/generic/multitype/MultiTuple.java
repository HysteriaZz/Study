package generic.multitype;

/**
 * Created by KaiLin.Guo on 2018-04-08.
 */
public class MultiTuple<A, B, C> {
    public final A first;
    public final B second;
    public final C three;

    public MultiTuple(A first, B second, C three) {
        this.first = first;
        this.second = second;
        this.three = three;
    }

    @Override
    public String toString() {
        return "MultiTuple{" +
                "first=" + first +
                ", second=" + second +
                ", three=" + three +
                '}';
    }
}
