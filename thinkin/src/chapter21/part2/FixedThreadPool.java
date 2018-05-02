package chapter21.part2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by KaiLin.Guo on 2018-05-02.
 * Executors.newFixedThreadPool(int);创建固定容量大小的缓冲池
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 7; i++)
            exec.execute(new LiftOff());
        exec.shutdown();
    }
}
