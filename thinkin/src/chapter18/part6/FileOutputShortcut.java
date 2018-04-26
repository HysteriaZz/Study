package chapter18.part6;

import java.io.*;

/**
 * Created by KaiLin.Guo on 2018-04-26.
 */
public class FileOutputShortcut {
    static String file = "thinkin/src/chapter18/part6/FileOutputShortcut.out";
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("thinkin/src/chapter18/part6/FileOutputShortcut.java")));

        PrintWriter out = new PrintWriter(file);
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ": " + s);

        }
        out.flush();

        in.close();
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }

}
