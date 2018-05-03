package chapter21.part2;

/**
 * Created by KaiLin.Guo on 2018-05-02.
 * Thread.yield()让步
 */
public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff" + ") ");
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
        System.out.println("\n" + "我是附任务");
    }
}
