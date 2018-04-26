package chapter18.part6;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * Created by KaiLin.Guo on 2018-04-26.
 * 加油
 * 格式化的内存输入
 * DataInputStream面向字节的IO，所以读取汉字可能导致乱码“加油”
 * DataInputStream可和ByteArrayInputStream配套使用
 */
public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException {
        try {
            DataInputStream in = new DataInputStream(new ByteArrayInputStream(
                    BufferedInputFile.read(
                            "thinkin/src/chapter18/part6/FormattedMemoryInput.java").getBytes()));
            while (true)
                System.out.println((char) in.readByte());
        } catch (EOFException e) {
            System.err.println("End of stream");
        }
    }
}
