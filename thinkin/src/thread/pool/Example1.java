package thread.pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by KaiLin.Guo on 2017-12-28.
 * ps: for(15) <= maximumPoolSize + workQueue && corePoolSize <= maximumPoolSize && LinkedBlockingQueue is better

 * java doc中，并不提倡我们直接使用ThreadPoolExecutor，而是使用Executors类中提供的几个静态方法来创建线程池：
 Executors.newCachedThreadPool();        //创建一个缓冲池，缓冲池容量大小为Integer.MAX_VALUE
 Executors.newSingleThreadExecutor();   //创建容量为1的缓冲池
 Executors.newFixedThreadPool(int);    //创建固定容量大小的缓冲池

 * 如果是CPU密集型任务，就需要尽量压榨CPU，参考值可以设为 NCPU+1，如果是IO密集型任务，参考值可以设置为2*NCPU
 */
public class Example1 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 200, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(5)); // LinkedBlockingQueue未指定大小默认Integer.MAX_VALUE
        for (int i = 0; i < 15; i++) {
            // MyTask task = new MyTask(i);
            Test task = new Test(i);
            executor.execute(task);
            System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" +
                    executor.getQueue().size() + "，已执行完别的任务数目：" + executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }

}

class MyTask implements Runnable {
    private int taskNum;

    public MyTask(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public void run() {
        System.out.println("正在执行task：" + taskNum);
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task：" + taskNum + "执行完毕");
    }

}

class Test extends Thread {
    private int taskNum;

    public Test(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public void run() {
        System.out.println("正在执行task：" + taskNum);
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task：" + taskNum + "执行完毕");
    }

}
