package util;

import java.util.HashMap;
import java.util.Map;

public class MySpring {
    private static Map<String, Object> beanMap = new HashMap<>();

    public static synchronized <T> T getBean(String className) {
        T obj = (T) beanMap.get(className);
        if (obj == null) {
            try {
                obj = (T) Class.forName(className).newInstance();
                beanMap.put(className, obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return obj;
    }
}
