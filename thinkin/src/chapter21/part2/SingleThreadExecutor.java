package chapter21.part2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by KaiLin.Guo on 2018-05-02.
 * Executors.newSingleThreadExecutor();创建容量为1的缓冲池
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
        exec.shutdown();
    }
}
