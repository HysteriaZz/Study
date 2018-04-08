package generic.wipe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by KaiLin.Guo on 2018-04-08.
 * 无界通配符
 */
public class UnboundedWildcards {
    static Map map1;
    static Map<?, ?> map2;
    static Map<String, ?> map3;
    static void assign1(Map map) {
        map1 = map;
    }
    static void assign2(Map<?, ?> map) {
        map2 = map;
    }

    static void assign3(Map<String, ?> map) {
        map3 = map;
    }

    //@SuppressWarnings("unchecked")
    public static void main(String[] args) {
        assign1(new HashMap());
        assign2(new HashMap());
        assign3(new HashMap()); // warning

        assign1(new HashMap<String, Integer>());
        assign2(new HashMap<String, Integer>());
        assign3(new HashMap<String, Integer>());

        // Collections.checkedCollection(); //Collections提供了一系列检查类型安全方法

    }
}
