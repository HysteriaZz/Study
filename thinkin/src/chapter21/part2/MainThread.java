package chapter21.part2;

/**
 * Created by KaiLin.Guo on 2018-05-02.
 */
public class MainThread {
    public static void main(String[] args) {

        new Thread(() -> {
            System.out.println("我是线程1");
        }, "线程1").start();

        new Thread(() -> {
            System.out.println("我是线程2");
        }, "线程2").start();

        // 任务
        LiftOff launch = new LiftOff();
        launch.run();

        System.out.println("我是主线程");
    }
}
