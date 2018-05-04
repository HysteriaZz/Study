package chapter21.part3;

/**
 * Created by KaiLin.Guo on 2018-05-04.
 * volatile作用于变量代表共享内存变量
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();
    public void cancel() {
        canceled = true;
    }
    public boolean isCanceled() {
        return canceled;
    }
}
