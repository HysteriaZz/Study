package chapter21.part3;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by KaiLin.Guo on 2018-05-04.
 * 使用原子类：AtomicInteger、AtomicLong、AtomicReference实现线程同步
 */
public class AtomicEvenGenerator extends IntGenerator {
    private AtomicInteger currentEvenValue = new AtomicInteger(0);

    @Override
    public int next() {
        return currentEvenValue.addAndGet(2);
    }
    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
