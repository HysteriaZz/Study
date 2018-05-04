package chapter21.part3;

/**
 * Created by KaiLin.Guo on 2018-05-04.
 * volatile限制：1、不能对递增等不是原子性操作产生影响 2、32位JVM上对long、double同样线程不安全，字撕裂
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public static int nextSerialNumber() {
        return serialNumber++;
    }
}
