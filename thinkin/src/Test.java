import java.io.Serializable;
import java.util.Random;

/**
 * Created by KaiLin.Guo on 2017-08-17.
 */
public class Test implements Serializable{
    private static final long serialVersionUID = -6811533618121635940L;
    private int i;
    private char c;
    ParValue parValue;
    private static Random random = new Random(47);
    private final int A = random.nextInt(20);
    static final int B = random.nextInt(20);

    public void showInitConfig() {
        //打印int&char初始值
        System.out.println(i + "/" + c);
        System.out.println(i++);
        System.out.println(++i);
        int i1 = 0x2f; //十六进制
        int i2 = 012; //八进制
        System.out.println("A:" + A);
        System.out.println("B:" + B);
    }
    Test(ParValue parValue){
        this.parValue = parValue;
    }
    Test(int i, int j){
        //this.showInitConfig();
        this(ParValue.YUAN);
        //this(2);
        //super.finalize();
    }
    void printTest(Character... args){
        System.out.println(args.getClass());
        System.out.println(args.length);
    }

    /**
     * 输出面值
     * 输出枚举及其所在位置
     */
    void describe(){
        switch (parValue){
            case YUAN: System.out.println("100");
                break;
            case CENT: System.out.println("10");
                break;
            case POINT: System.out.println("1");
                break;
            default: //do nothing
        }
        for (ParValue s : ParValue.values()){
            System.out.println(s + "|" + s.ordinal());
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Test test = (Test) o;

        if (i != test.i) return false;
        return c == test.c;
    }

    @Override
    public int hashCode() {
        int result = i;
        result = 31 * result + (int) c;
        return result;
    }
}

enum ParValue{
    YUAN, CENT, POINT
}

class Userful {
    public void f(){
        System.out.println("fx");
    }
}

class MoreUserful extends Userful {
    public void g(){
        System.out.println("gx");
    }
}

interface Selector {
    boolean end();
    Object current();
    void next();
}

class Sequence {
    private  Object[] items;
    private int next = 0;
    public Sequence(int size) {items = new Object[size]; }
    public void add(Object x){
        if (next < items.length)
            items[next++] = x;
    }
    private class SequenceSelector implements Selector {
        private int i = 0;
        @Override
        public boolean end() {return i == items.length; }
        @Override
        public Object current() {return items[i]; }
        @Override
        public void next() { if (i < items.length) i++; }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

}

class Father {
    public int strong() {
        return 180;
    }
}

class Mother {
    public int kind() {
        return 18;
    }
}

class Son {
    class Father_1 extends Father{
        public int strong(){
            return super.strong() + 1;
        }
    }

    class Mother_1 extends Mother{
        public int kind(){
            return super.kind() + 1;
        }
    }

    public int getStrong(){
        return new Father_1().strong();
    }

    public int getKind(){
        return new Mother_1().kind();
    }
}

abstract class Shape {
    abstract public void draw();
}

class Circle extends Shape {
    public void draw() {

    }
}

interface La {
    public void la0();
    public void la1();
}

class Lb {
    public void la0() {

    }
}

class Lc extends Lb implements La {
    @Override
    public void la1() {

    }
}