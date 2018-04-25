package chapter18.part1;

import java.io.File;

/**
 * Created by KaiLin.Guo on 2018-04-25.
 * 使用Directory工具
 */
public class DirectoryDemo {
    public static void main(String[] args) {
        PPrint.pprint(Directory.TreeInfo.walk(".").dirs);
        for (File file : Directory.local(".", "T.*"))
            System.out.println(file);
        System.out.println();
        System.out.println("---------------------------------");
        for (File file : Directory.TreeInfo.walk(".", "T.*\\.java"))
            System.out.println(file);
        System.out.println("=================================");
        for (File file : Directory.TreeInfo.walk(".", ".*[Zz].*\\.class"))
            System.out.println(file);
    }
}
