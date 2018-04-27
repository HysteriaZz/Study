package chapter18.part8;

import java.io.PrintWriter;

/**
 * Created by KaiLin.Guo on 2018-04-27.
 * 将System.out转换成PrintWriter
 */
public class ChangeSystemOut {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Hello, world");
    }
}
