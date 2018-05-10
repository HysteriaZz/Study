package other;

/**
 * Created in 2018/5/10 By:Will.li
 *
 * 找不出错哪了。。！！
 */
/*
编写一个程序，首先要定义一个外部类，在这个类里还要定义一个内部类InnerClass，
这里InnerClass类是一个成员内部类
 */
public class E01_OutClass {
    String var = "外部类";
    private int width = 4;
    private static int height = 6;
    public E01_OutClass(int width ,int height){
        this.width = width;
        this.height = height;
        System.out.println("Outclass width="+this.width+" height="+this.height);
    }
    private void outOne(){
        System.out.println("正在访问外部类非静态方法");
        InClass inner = this.new InClass();
    }
    private static void outTwo(){
        System.out.println("正在访问外部类静态方法");
    }

    class InClass {
        String var = "内部类";
        public InClass(){
            System.out.println("创建了一个内部类对象");
        }
        private void shouVarValue(){
            System.out.println("外部类width="+width);
            System.out.println("外部类height="+height);
        }
        private void inMethod(){
            System.out.println("允许内部类访问外部类的private方法");
            outOne();
            outTwo();
        }
    }
}
