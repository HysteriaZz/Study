package chapter21.part2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by KaiLin.Guo on 2018-05-03.
 * 线程优先级Thread.MIN_PRIORITY、Thread.MAX_PRIORITY、Thread.NORM_PRIORITY
 */
public class SimplePriorities implements Runnable {
    private int countDown = 5;
    // volatile轻量级的同步机制，共享变量内存共享，多个线程操作同一个对象时
    private volatile double d;

    private int priority;

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return Thread.currentThread() + ": " + countDown + String.valueOf(d);
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true) {
            for (int i = 0; i < 100000; i++) {
                // double初始d为0.00,除以零为无穷大Infinity,int则会报异常/by zero
                d += (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0)
                    Thread.yield();
            }
            System.out.println(this);
            if (--countDown == 0)
                return;
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        exec.shutdown();
    }
}
