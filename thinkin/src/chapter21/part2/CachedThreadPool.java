package chapter21.part2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by KaiLin.Guo on 2018-05-02.
 * Executors.newCachedThreadPool();创建一个缓冲池，缓冲池容量大小为Integer.MAX_VALUE
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
        exec.shutdown();
    }
}
