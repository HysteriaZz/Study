package chapter18.part6;

import java.io.*;

/**
 * Created by KaiLin.Guo on 2018-04-26.
 * 存储和恢复
 */
public class StoringAndRecoveringData {
    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("thinkin/src/chapter18/part6/Data.txt")));
        out.writeDouble(3.14159);
        out.writeUTF("this was pi");
        out.writeDouble(1.41413);
        out.writeUTF("Square root of 2");
        out.close();

        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("thinkin/src/chapter18/part6/Data.txt")));
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
    }
}
