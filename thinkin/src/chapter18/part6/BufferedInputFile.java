package chapter18.part6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by KaiLin.Guo on 2018-04-26.
 * 缓存输入文件并控制台打印
 * 读文件什么的用面向字符的Reader子类BufferedReader即可，但是用于zip压缩等需要用到面向字节InputStream
 */
public class BufferedInputFile {
    public static String read(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null)
            sb.append(s + "\n");
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(read("thinkin/src/chapter18/part6/BufferedInputFile.java"));
    }
}
