package prototype;

import java.io.*;

/**
 * Created by KaiLin.Guo on 2017-11-29.
 * 两种复制都是对象属性的复制
 */
public class Prototype implements Cloneable, Serializable {

    private static final long serialVersionUID = 633061453755190488L;

    private String[] string = new String[1];

    private int id;

    private String s;

    /**
     * 浅复制：复制int/Integer/String等类型安全，对于数组等类型不安全
     * 对值类型的成员变量进行值的复制,对引用类型的成员变量只复制引用,不复制引用的对象
     * @return
     * @throws CloneNotSupportedException
     */
    public Prototype clone() throws CloneNotSupportedException {
        Prototype prototype = (Prototype)super.clone();
        return prototype;
    }

    /**
     * 深复制
     * 对值类型的成员变量进行值的复制,对引用类型的成员变量也进行引用对象的复制
     * 把对象写到流里的过程是序列化(Serialization)过程，而把对象从流中读出来的过程则叫反序列化(Deserialization)过程
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Prototype deepClone() throws IOException, ClassNotFoundException {

        // 写入当前对象的二进制流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        // 读出二进制流产生的新对象
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (Prototype)ois.readObject();
    }

    public String getString() {
        return string[0];
    }

    public void setString(String string) {
        this.string[0] = string;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
