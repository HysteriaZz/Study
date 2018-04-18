package chapter17.part6;

import java.util.*;

/**
 * Created by KaiLin.Guo on 2018-04-10.
 * Set、SortedSet、HashSet、TreeSet、LinkedHashSet
 * 几种Set判断重复的方法
 * Set、SortedSet：根据equals方法
 * TreeSet：根据compareTo方法且必须实现
 * HashSet、LinkedHashSet：根据hashCode方法和equals方法
 * 几种Set的排序
 * Set：无序
 * SortedSet：根据对象的比较函数排序
 * TreeSet：存储和遍历顺序按红黑树，底层是TreeMap实现的
 * HashSet：hashcode方法
 * LinkedHashSet：按插入顺序
 * PS：容器内元素hashcode获取：若元素重写了hashcode方法则使用已重写的，基本类型String都已重写（按每个char字符求得）
 * ，否则使用Object类的默认是本地方法native（c或c++语言）取得
 */
public class TypesForSets {
    static <T> Set<T> fill(Set<T> set, Class<T> type) {
        try {
            for (int i = 0; i < 10; i++)
                set.add(type.getConstructor(int.class).newInstance(i));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return set;
    }

    static <T> void test(Set<T> set, Class<T> type) {
        fill(set, type);
        fill(set, type);
        fill(set, type);
        System.out.println(set);
    }

    public static void main(String[] args) {
        // TreeSet中TreeType的compareTo方法存在相等故不存在重复
        // HashSet和LinkedHashSet根据hashcode所以可能存在相等故不存在重复
        test(new TreeSet<TreeType>(), TreeType.class);
        test(new HashSet<HashType>(), HashType.class);
        test(new LinkedHashSet<HashType>(), HashType.class);

        // HashSet和LinkedHashSet根据hashcode但是SetType和TreeType无hashcode故存在重复
        test(new HashSet<SetType>(), SetType.class);
        test(new HashSet<TreeType>(), TreeType.class);
        test(new LinkedHashSet<SetType>(), SetType.class);
        test(new LinkedHashSet<TreeType>(), TreeType.class);

        try {
            test(new TreeSet<SetType>(), SetType.class);
        } catch (Exception e) {
            // java.lang.ClassCastException: chapter17.part6.SetType cannot be cast to java.lang.Comparable
            System.out.println(e.getMessage());
        }

        try {
            test(new TreeSet<HashType>(), HashType.class);
        } catch (Exception e) {
            // java.lang.ClassCastException: chapter17.part6.SetType cannot be cast to java.lang.Comparable
            System.out.println(e.getMessage());
        }

        LinkedHashSet k = new LinkedHashSet();
        k.add("1");
        k.add("2");
        k.add("1");
        k.add(1);
        System.out.println(k);

    }
}

class SetType {
    int i;

    public SetType(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof SetType && (i == ((SetType)obj).i);
//        return true;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}

class HashType extends SetType {
    private static int j = 1;

    public HashType(int i) {
        super(i);
    }

    @Override
    public int hashCode() {
        return i;
//         return j++;
    }
}

class TreeType extends SetType implements Comparable<TreeType> {
    public TreeType(int i) {
        super(i);
    }

    @Override
    public int compareTo(TreeType o) {
        return o.i < i ? -1 : (o.i == i ? 0 : 1);
//        return 1;
    }

}
