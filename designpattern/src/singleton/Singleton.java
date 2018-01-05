package singleton;

import java.util.Vector;

/**
 * Created by KaiLin.Guo on 2017-11-28.
 * 1、某些类创建比较频繁，对于一些大型的对象，这是一笔很大的系统开销。
 * 2、省去了new操作符，降低了系统内存的使用频率，减轻GC压力。
 * 3、有些类如交易所的核心交易引擎，控制着交易流程，如果该类可以创建多个的话，系统完全乱了。所以只有使用单例模式，才能保证核心交易服务器独立控制整个流程。
 */
public class Singleton {

    private static Singleton instance = null;

    private Vector properties = null;

    public Vector getProperties() {
        return properties;
    }

    /**
     * 私有构造方法，防止被实例化
     */
    private Singleton() {
    }

    private static synchronized void syncInit() {
        if (instance == null) {
            instance = new Singleton();
        }
    }

    /**
     * 获取实例
     * @return
     */
    public static Singleton getInstance() {
        if (instance == null) {
            syncInit();
        }
        return instance;
    }

    public void updateProperties() {
        Singleton shadow = new Singleton();
        properties = shadow.getProperties();
    }
}
