package chapter18.part6;

import java.io.*;

/**
 * Created by KaiLin.Guo on 2018-04-26.
 * 基本的文件输出并打印行号
 * 读文件内容写入另一个文件
 */
public class BasicFileOutput {
    static String file = "thinkin/src/chapter18/part6/BasicFileOutput.out";
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("thinkin/src/chapter18/part6/BasicFileOutput.java")));
        // 若file文件不存在会创建一个新的空文件，第二个参数append为true时表示追加
//        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
//        FileWriter out =  new FileWriter(file, true);
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
//            out.println(lineCount++ + ": " + s);
            out.write(lineCount++ + ": " + s + "\n");

        }
        out.flush();

        in.close();
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }

}
