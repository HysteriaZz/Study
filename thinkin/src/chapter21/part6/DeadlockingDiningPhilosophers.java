package chapter21.part6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by KaiLin.Guo on 2018-05-07.
 * 死锁 以下四个条件同时满足
 * 1、互斥条件 一根Chopstick一次只能被一个Philosopher使用
 * 2、至少有一个资源并且正在等待一个被其它任务持有的资源 Philosopher必须拿着一根Chopstick并且等待另一根
 * 3、资源不能被强占 不会从其它Philosopher那里抢Chopstick
 * 4、必须循环等待 A->B->C->A
 */
public class DeadlockingDiningPhilosophers {
    public static void main(String[] args) throws Exception {
        int ponder = 5;
        if (args.length > 0)
            ponder = Integer.parseInt(args[0]);
        int size = 5;
        if (args.length > 1)
            size = Integer.parseInt(args[1]);
        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick[] sticks = new Chopstick[size];
        for (int i = 0; i < size; i++)
            sticks[i] = new Chopstick();
        for (int i = 0; i < size; i++)
            exec.execute(new Philosopher(sticks[i], sticks[(i + 1) % size], i, ponder));

        if (args.length == 3 && args[2].equals("timeout"))
            TimeUnit.SECONDS.sleep(5);
        else {
            System.out.println("Press 'Enter' to quit");
            System.in.read();
        }

        exec.shutdown();
//        exec.shutdownNow();
    }
}
