package chapter21.part2;

/**
 * Created by KaiLin.Guo on 2018-05-02.
 */
public class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
