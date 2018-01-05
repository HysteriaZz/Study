package thread.instance;

/**
 * Created by KaiLin.Guo on 2017-12-27.
 * 线程通信
 * 设计四个线程对象对同一个数据进行操作，两个线程执行减操作，两个线程执行加操作
 */
public class ThreadAddSub extends Thread {
    boolean operate = true;
    static int sum = 0;

    public ThreadAddSub(boolean operate) {
        super();
        this.operate = operate;
    }

    @Override
    public void run() {
        super.run();

        while (true) {
            if (operate) {
                sum += 4;
                System.out.println("加后，sum = " + sum);
            } else {
                sum -= 4;
                System.out.println("减后，sum = " + sum);
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadAddSub[] tSub = new ThreadAddSub[4];
        for (int i = 0; i < tSub.length; i++) {
            tSub[i] = new ThreadAddSub(i%2 == 0 ? true:false);
            tSub[i].start();
        }
    }
}
