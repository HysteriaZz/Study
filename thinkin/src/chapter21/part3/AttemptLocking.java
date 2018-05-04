package chapter21.part3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by KaiLin.Guo on 2018-05-04.
 * 用ReentrantLock尝试获取锁或者一段时间，然后解锁
 * 如果其它人已经获取这个锁，可以去做其它时期而不是等待，这种情况直接lock.lock()可能导致阻塞
 */
public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();
    public void untimed() {
//        try {
//            Thread.sleep(5000);
//        } catch (Exception e) {
//
//        }
//        lock.lock();
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock(): " + captured);
        } finally {
            if (captured)
                lock.unlock();
        }
    }

    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("tryLock(2, TimeUnit.MILLISECONDS): " + captured);
        } finally {
            if (captured)
                lock.unlock();
        }
    }

    public static void main(String[] args) {
        final AttemptLocking al = new AttemptLocking();
//        new Thread() {
//            {setDaemon(true);}
//            public void run() {
//                al.lock.lock();
//                System.out.println("acquired");
//            }
//        }.start();

        al.untimed();
        al.timed();

        new Thread() {
            {setDaemon(true);}
            public void run() {
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();

        Thread.yield();
        al.untimed();
        al.timed();
    }
}
