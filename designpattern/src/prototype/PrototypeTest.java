package prototype;

/**
 * Created by KaiLin.Guo on 2017-11-29.
 */

import java.io.IOException;

/**
 * PS：和对象直接=赋值不同，对象直接赋值是拷贝的对象的引用，这里指的是属性的copy
 */
public class PrototypeTest  {
    public static void main(String[] args) {
        Prototype proto1 = new Prototype();
        proto1.setId(1);
        proto1.setS("proto1");
        proto1.setString("proto1");
        // 浅复制
        try {
            Prototype proto2 = proto1.clone();
            proto2.setId(2);
            proto2.setS("proto2");
            proto2.setString("proto2");
            System.out.println(proto1.getString() + " | " +  proto2.getString());
            System.out.println(proto1.getS() + " | " +  proto2.getS());
            System.out.println(proto1.getId() + " | " + proto2.getId());

        } catch (CloneNotSupportedException e) {
            System.out.println("CloneNotSupportedException");
        }
        // 深复制
        Prototype proto3 = new Prototype();
        proto3.setId(3);
        proto3.setS("proto3");
        proto3.setString("proto3");
        try {
            Prototype proto4 = proto3.deepClone();
            proto4.setId(4);
            proto4.setS("proto4");
            proto4.setString("proto4");
            System.out.println(proto3.getString() + " | " +  proto4.getString());
            System.out.println(proto3.getS() + " | " +  proto4.getS());
            System.out.println(proto3.getId() + " | " + proto4.getId());
        } catch (IOException e) {
            System.out.println("IOException");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException");
        }
    }
}
