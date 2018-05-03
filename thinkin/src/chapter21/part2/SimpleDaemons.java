package chapter21.part2;

import java.util.concurrent.TimeUnit;

/**
 * Created by KaiLin.Guo on 2018-05-03.
 * 后台线程，默认都是非后台线程，设置为后台线程daemon.setDaemon(true)，若main线程终止则后台线程也终止，除非存在其他非后台线程还在运行
 * 只要有任何非后台线程还在运行，程序就不会终止，比如，执行main()的就是一个非后台线程
 * 如果一个线程是后台线程，那它创建的其他线程也是后台线程
 */
public class SimpleDaemons implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(60000);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            // 设置为后台线程
            daemon.setDaemon(true);
            daemon.start();
        }

        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}
