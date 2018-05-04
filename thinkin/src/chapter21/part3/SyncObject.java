package chapter21.part3;

/**
 * Created by KaiLin.Guo on 2018-05-04.
 * DualSynch.f()在this上同步，而g()有一个在syncObject上同步的synchronized块
 * 这两个同步是相互独立的，所以任何一个方法没有因为对另外一个方法的同步而阻塞
 */
class DualSynch {
    private Object syncObject = new Object();
    public synchronized void f() {
        for (int i = 0; i < 5; i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }

    public void g() {
        synchronized (syncObject) {
            for (int i = 0; i < 5; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}

public class SyncObject {
    public static void main(String[] args) {
        final DualSynch ds = new DualSynch();
        new Thread(()->{
            ds.f();
        }).start();
        ds.g();
    }

}
