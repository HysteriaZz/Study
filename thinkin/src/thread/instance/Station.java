package thread.instance;

/**
 * Created by KaiLin.Guo on 2017-12-26.
 * 多线程之对同一个数量进行操作
 * 例：三个售票窗口同时出售20张票
 */
public class Station extends Thread {

    /**
     * 线程取名
     * @param name
     */
    public Station(String name) {
        super(name);
    }

    /**
     * 总票数
     */
    static int tick = 20;

    /**
     * 静态钥匙
     */
    static Object ob = "ab";

    @Override
    public void run() {
        while (tick > 0) {
            // 加锁防止不同车站卖出同一张车票
            synchronized(ob) {
                if (tick > 0) {
                    System.out.println(getName() + "卖出了第" + tick + "张票");
                    tick--;
                } else {
                    System.out.println("票卖完了");
                }
            }

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {

        Station station1 = new Station("窗口1");
        Station station2 = new Station("窗口2");
        Station station3 = new Station("窗口3");

        station1.start();
        station2.start();
        station3.start();
    }
}
