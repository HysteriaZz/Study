package other;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by KaiLin.Guo on 2017-08-16.
 */
public class MyThinkInApp {
    public static void main(String[] args){


        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            Date date = sdf.parse("12:01");
            System.out.println(DateFormat.getTimeInstance().format(date));
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Hello Thinking In Java");
        System.getProperties().list(System.out);
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.library.path"));
        Test test = new Test(ParValue.POINT);
        test.showInitConfig();
        test.printTest('a');
        test.describe();

        Test test1 = new Test(ParValue.POINT);
        test1.showInitConfig();

        Userful[] x = {new Userful(), new MoreUserful()}; // 向上转型
        x[0].f();
        x[1].f(); //only f()
        //((other.MoreUserful)x[0]).g(); // 向下转型
        ((MoreUserful)x[1]).g();

        //other.Userful y = new other.Userful();
        //((other.MoreUserful)y).g(); // Exception other.Userful cannot be cast to other.MoreUserful

        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++){
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.selector();
        //other.Selector selector1 = sequence.new SequenceSelector();

        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }

        // 内部类多重继承
        Son son = new Son();
        son.getKind();
        son.getStrong();

        ArrayList apples = new ArrayList(); // Object
        apples.add("1");
        apples.add(1);
        apples.toArray();
        apples.clear();
        apples.isEmpty();

        Collection<Integer> c = new ArrayList<Integer>();
        c.add(1);
        c.add(2);
        Iterator<Integer> iterator = c.iterator(); // 迭代器
        while (iterator.hasNext()) {
            System.out.println("see:" + iterator.next());
        }

        Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        Integer[] moreInts = {4, 5, 6};
        collection.addAll(Arrays.asList(moreInts));
        //collection.addAll(Arrays.<Integer>asList(moreInts)); // 指定类型Integer

        Collections.addAll(collection, 7, 8, 9);
        Collections.addAll(collection, moreInts);

        System.out.printf("\n");
        System.out.println(PrintingContainers.fill(new ArrayList<String>())); // 按添加顺序遍历
        System.out.println(PrintingContainers.fill(new LinkedList<String>())); // 按添加顺序遍历，可用来实现栈

        System.out.println(PrintingContainers.fill(new HashSet<String>())); // 无序，一般只关心某元素是否是其成员
        System.out.println(PrintingContainers.fill(new TreeSet<String>())); // 按键值升序遍历，红-黑树
        System.out.println(PrintingContainers.fill(new LinkedHashSet<String>())); // 按添加顺序遍历，散列函数

        System.out.println(PrintingContainers.fill(new HashMap<String, String>())); // 无序，一般只根据key查找值，相同key值会被后面覆盖
        System.out.println(PrintingContainers.fill(new TreeMap<String, String>())); // 按键值升序遍历
        System.out.println(PrintingContainers.fill(new LinkedHashMap<String, String>())); // 按添加顺序遍历

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.peek() + "|" + stack.pop());

        Random random = new Random(47);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < 10000; i++) {
            int r = random.nextInt(20);
            Integer freq = map.get(r);
            map.put(r, freq == null ? 1 : freq + 1);
        }
        System.out.println(map);
        System.out.println("map keySet:" + map.keySet()); // 输出map中所有key值
        for (Integer i : map.keySet()){
            System.out.println(map.get(i));
        }
        Iterator<Integer> ll = map.keySet().iterator();
        while (ll.hasNext()) {
            System.out.println(ll.next());
        }

        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + "|" + entry.getValue());
        }

        Map<Integer, List<String>> iS = new HashMap<Integer, List<String>>();
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(3);
        queue.add(5);
        queue.offer(2);
        queue.add(1);
        System.out.println(queue);

        PriorityQueue<Character> priorityQueue = new PriorityQueue<Character>(); // 默认自然顺序
        priorityQueue.offer('b');
        priorityQueue.add('a');
        priorityQueue.offer('c');
        priorityQueue.add('d');
        System.out.println(priorityQueue);

        for (String s : new IterableClass()) {
            System.out.printf(s + " ");
        }

        try {
            double pp = 1/0;
        } catch (Exception e) {
            e.printStackTrace(System.out); // at other.MyThinkInApp.main(other.MyThinkInApp.java:127) 白
            System.out.printf("\n");
            e.printStackTrace(); // java.lang.ArithmeticException: / by zero at other.MyThinkInApp.main(other.MyThinkInApp.java:127) 打印到标准错误流 红
        }

        List<Integer> tempList = new ArrayList<Integer>();
        if (tempList.size() > 0) {
            System.out.println(tempList.get(0));
        }

        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.print("Caught " + e); // err 严重错误
        }

        if (true) {
            //throw new other.LoggingRuntime(); // 运行时异常直接对外抛，但是一般不，若未处理后面语句将不被执行
        }

        // break 跳出里层循环，tag + break 跳出标记tag层循环
        // continue 执行下一次循环，tag + continue 执行tag层下一次循环
        System.out.println("begin to circulating.");
        loop:for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 2 && j==3) {
                    System.out.println("break is executed!");
                    break loop;
                }
                System.out.print(i + "*" + j + "=" + i * j + "    ");
            }
            System.out.println();
        }

        List<Test> ii = new ArrayList<Test>();
        ii.add(new Test(2, 2));
        ii.add(new Test(3, 3));
        System.out.println(ii.toString());

        Formatter f = new Formatter(System.out);
        f.format("%s,%d", "gg", 5);

        System.out.println("huhjk".matches("[a-z][aeiu][h].+") == true);

        String[] bb = {"abcabcabcdefabc", "abc+", "(abc)+", "(abc){2,}"};

        if(bb.length < 2) {
            System.out.println("Usage:\njava TestRegularExpression " + "CharacterSequence regularExpression+");
            System.exit(0);
        }
        System.out.println("Input: \"" + bb[0] + "\"");
        for (String b : bb) {
            System.out.println("Regular expression: \"" + b + "\"");
            Pattern p = Pattern.compile(b);
            Matcher m = p.matcher(bb[0]);
            while (m.find()) {
                System.out.println("Math \"" + m.group() + "\" at positions " + m.start() + "-" + (m.end() - 1));
            }

        }
        System.out.println(Arrays.toString(Pattern.compile("!!").split("This!!unusual use !!of exclamation!!points")));
        BufferedReader input = new BufferedReader(new StringReader("Sir Robin of Camelot\n22 1.61802"));
        try {
            System.out.println(input.readLine());
        } catch(IOException e) {
            System.err.println("I/O exception");

        }
        try {
            Class c1 = Class.forName("other.Userful"); // or use classname.class
            System.out.println(c1 + c1.getClasses().toString());
            Object o1 = c1.newInstance();
            System.out.println(o1 + o1.getClass().toString());

        } catch (Exception e) {
            System.out.println("Can't find other.IterableClass or ...");
            System.exit(1); //<>0-非正常退出
        }
        FilledList<CountInteger> fl = new FilledList<CountInteger>(CountInteger.class);
        System.out.println(fl.create(15));

        CountInteger countInteger = new CountInteger();
        boolean b = countInteger instanceof CountInteger;

        Map<Integer, Integer> paramMap = new HashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> entry : paramMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

    }

}

class CountInteger {
    private static long counter;
    private final long id = counter++;
    public String toString() {return Long.toString(id); }
}

class FilledList<T> {
    private Class<T> type;
    public FilledList(Class<T> type) {
        this.type = type;
    }
    public List<T> create(int nElements) {
        List<T> result = new ArrayList<T>();
        try {
            for (int i = 0; i < nElements; i++)
                result.add(type.newInstance());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}

class IterableClass implements Iterable<String> {
    protected String[] words = ("And that is how " + "we know the Earth to be banana-shaped.").split(" ");
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            public boolean hasNext() {
                return index < words.length;
            }
            public String next() {
                return words[index++];
            }
            public void remove() {
                throw new UnsupportedOperationException();
            }

        };
    }
}

class PrintingContainers {
    static Collection fill(Collection<String> collection) {
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        collection.add("dog");
        collection.add("aoc");
        return collection;
    }
    static Map fill(Map<String, String> map) {

        map.put("cat", "Rags");
        map.put("dog", "Bosco");
        map.put("dog", "Spot");
        map.put("aoc", "Boom");
        return map;
    }
}

/**
 * 普通异常类，对外抛异常需要throws
 */
class LoggingException extends BaseException {
    private static Logger logger = Logger.getLogger("other.LoggingException");
    public LoggingException() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString()); // severe日志级别
    }
    public void fx() throws LoggingException{
        throw new LoggingException();
    }
}

class BaseException extends Exception {

}

/**
 * 运行时异常，对外抛异常不需要throws，一般catch就行或直接对外抛
 */
class LoggingRuntime extends BaseRuntimeException {
    private static Logger logger = Logger.getLogger("other.LoggingException");
    public LoggingRuntime() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.warning(trace.toString()); // severe日志级别
    }
    public void gx() {
        throw new LoggingRuntime();
    }
}

class BaseRuntimeException extends RuntimeException {

}

