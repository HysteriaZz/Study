package chapter18.part1;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by KaiLin.Guo on 2018-04-23.
 * 目录列表器
 */
public class DirList {
    public static void main(String[] args) {
        // File代表路径
        File path = new File(".");
        String[] list;
        if (args.length == 0)
            list = path.list();
        else
            list = path.list(new DirFilter(args[0]));
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list)
            System.out.println(dirItem);
    }

    public static FilenameFilter filter(final String regex) {
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);

            @Override
            public boolean accept(File dir, String name) {
                return false;
            }
        };
    }

}

class DirFilter implements FilenameFilter {
    private Pattern pattern;
//    private String regex;

    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);
//        this.regex = regex;
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
//        return name.matches(regex);
    }
}
