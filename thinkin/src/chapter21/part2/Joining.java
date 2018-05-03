package chapter21.part2;


/**
 * Created by KaiLin.Guo on 2018-05-03.
 * 加入一个线程
 * 如果一个线程在另一个线程t上调用t.join()，此线程将被挂起，直到目标线程t结束才恢复
 */
class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(getName() + " join completed");
    }
}

class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            // InterruptedException被捕获时会清理这个标志，所以这里isInterrupted总为false
            System.out.println(getName() + " was interrupted. " + "isInterrupted(): " + isInterrupted());
            return;
        }
        System.out.println(getName() + " has awakened");
    }
}

public class Joining {
    public static void main(String[] args) throws Exception {
        Sleeper
            sleeper = new Sleeper("Sleeper", 1500),
            grumpy = new Sleeper("Grumpy", 1500);
        Joiner
            dopey = new Joiner("Dopey", sleeper),
            doc = new Joiner("Doc", grumpy);

        grumpy.interrupt();
    }

}
