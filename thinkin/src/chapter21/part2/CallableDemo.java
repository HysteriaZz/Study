package chapter21.part2;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by KaiLin.Guo on 2018-05-03.
 * 从任务中产生返回值
 * 使用ExecutorService.submit()方法调用
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            results.add(exec.submit(new TaskWithResult(i)));
        for (Future<String> fs : results)
            try {
                // get()方法将阻塞直至结果获取到，也可设置超时时间
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                System.out.println(e);
                return;
            } catch (ExecutionException e) {
                System.out.println(e);
            } finally {
                exec.shutdown();
            }
    }

}

class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(30000);
        return "result of TaskWithResult " + id;
    }
}
