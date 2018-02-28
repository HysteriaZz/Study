package generic.tofunction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by KaiLin.Guo on 2018-02-28.
 */
public class New {
    public static <K, V> Map<K, V> map() {
        return new HashMap<K, V>();
    }

    public static void main(String[] args) {
        Map<String, List<String>> sls = New.map();
    }
}
