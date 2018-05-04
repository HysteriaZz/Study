package chapter21.part4;


/**
 * Created by KaiLin.Guo on 2018-05-04.
 * 被互斥所阻塞
 * 阻塞方式：1、sleep 2、wait 3、等待输入或输出 4、等待锁释放
 */
public class MutiLock {
    public synchronized void f1(int count) {
        if (count-- > 0) {
            System.out.println("f1() calling f2() with count " + count);
            f2(count);
        }
    }

    public synchronized void f2(int count) {
        if (count-- > 0) {
            System.out.println("f2() calling f1() with count " + count);
            f1(count);
        }
    }

    public static void main(String[] args) throws Exception {
        final MutiLock mutiLock = new MutiLock();
        new Thread(() -> {
            mutiLock.f1(10);
        }).start();
    }
}
