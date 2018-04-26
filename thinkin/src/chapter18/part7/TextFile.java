package chapter18.part7;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by KaiLin.Guo on 2018-04-26.
 * 文件读写实用工具
 */
public class TextFile extends ArrayList<String> {

    /**
     * Read a file as a single string
     * @param fileName
     * @return
     */
    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sb.toString();
    }

    /**
     * Write a single file in one method call
     * @param fileName
     * @param text
     */
    public static void write(String fileName, String text) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Read a file, split by any regular expression
     * @param fileName
     * @param splitter
     */
    public TextFile(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
        if (get(0).equals(""))
            remove(0);
    }

    /**
     * Normally read by line
     * @param fileName
     */
    public TextFile(String fileName) {
        this(fileName, "\n");
    }

    /**
     * Write a single file in one method call
     * @param fileName
     */
    public void write(String fileName) {
        try {
            PrintWriter out = new PrintWriter(
                    new File(fileName).getAbsoluteFile());
            try {
                for (String item : this)
                    out.println(item);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String file = read("thinkin/src/chapter18/part7/TextFile.java");
        write("thinkin/src/chapter18/part7/test.txt", file);

        TreeSet<String> words = new TreeSet<>(new TextFile("thinkin/src/chapter18/part7/TextFile.java", "\\W+"));
        System.out.println(words.headSet("a"));
    }
}
