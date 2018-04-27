package chapter18.part11;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by KaiLin.Guo on 2018-04-27.
 * 用GZIP进行简单的压缩.gz
 * 单个文件的压缩与读取压缩后的文件
 * 大概压缩了一半
 */
public class GZIPcompress {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Usage: \nGZIPcompress file\n" +
                    "\tUsers GZIP compression to compress " +
            "the file to test.gz");
            System.exit(1);
        }
        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("thinkin/src/chapter18/part11/test.gz")));
        System.out.println("Writing file");
        int c;
        while ((c = in.read()) != -1)
            out.write(c);
        in.close();
        out.close();

        System.out.println("Reading file");
        BufferedReader in2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("thinkin/src/chapter18/part11/test.gz"))));
        String s;
        while ((s = in2.readLine()) != null)
            System.out.println(s);

    }
}
