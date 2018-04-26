package chapter18.part6;

import java.io.*;

/**
 * Created by KaiLin.Guo on 2018-04-26.
 * 检测输入是否结束
 */
public class TestEOF {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(
                new FileInputStream(
                        "thinkin/src/chapter18/part6/TestEOF.java")));
        while (in.available() != 0)
            System.out.println((char) in.readByte());
    }
}
