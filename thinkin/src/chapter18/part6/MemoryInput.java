package chapter18.part6;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by KaiLin.Guo on 2018-04-26.
 * 从内存中输入，读String内存数据
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read("thinkin/src/chapter18/part6/MemoryInput.java"));
        int c;
        // read以int形式返回下一字符
        while ((c = in.read()) != -1)
            System.out.println((char)c);
    }
}
