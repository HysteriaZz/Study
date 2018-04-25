package chapter18.part1;

import java.io.File;
import java.io.IOException;

/**
 * Created by KaiLin.Guo on 2018-04-25.
 * 策略模式
 * 迭代出匹配的文件并打印文件路径
 */
public class ProcessFiles {

    public interface Strategy {
        void process(File file);
    }

    private Strategy strategy;
    private String ext;

    public ProcessFiles(Strategy strategy, String ext) {
        this.strategy = strategy;
        this.ext = ext;
    }

    public void start(String[] args) {
        try {
            if (args.length == 0)
                processDirectoryTree(new File("."));
            else
                for (String arg : args) {
                    File fileArg = new File(arg);
                    if (fileArg.isDirectory())
                        processDirectoryTree(fileArg);
                    else
                        if (!arg.endsWith("." + ext))
                            arg += "." + ext;
                    strategy.process(new File(arg).getCanonicalFile());
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 迭代出匹配的文件并打印文件路径
     * @param root
     * @throws IOException
     */
    public void processDirectoryTree(File root) throws IOException {
        for (File file : Directory.TreeInfo.walk(root.getAbsolutePath(), ".*\\." + ext))
            strategy.process(file.getCanonicalFile());
    }

    public static void main(String[] args) {
        new ProcessFiles(new Strategy() {
            @Override
            public void process(File file) {
                System.out.println(file);
            }
        }, "java").start(args);

        // 拉姆达表达式1.8
        new ProcessFiles((File file) -> {
            System.out.println(file);
        }, "java").start(args);
    }
}
