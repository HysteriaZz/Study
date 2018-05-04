package chapter21.part3;

/**
 * Created by KaiLin.Guo on 2018-05-04.
 * 使用同步控制synchronized解决共享资源竞争，可应用到函数、变量、代码块
 * 不加将可能输出奇数
 */
public class SynchronizedEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    @Override
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
