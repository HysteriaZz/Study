package chapter18.part10;


import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * Created by KaiLin.Guo on 2018-04-27.
 * 文件加锁
 */
public class FileLocking {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("thinkin/src/chapter18/part10/file.txt");
        FileLock fl = fos.getChannel().tryLock();
        if (fl != null) {
            System.out.println("Locked File");
            TimeUnit.MILLISECONDS.sleep(60000);
            fl.release();
            System.out.println("Released Lock");
        }
        fos.close();
    }
}
