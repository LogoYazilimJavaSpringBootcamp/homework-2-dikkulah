package singleton;

import java.util.ArrayList;
import java.util.List;

public class LazySingleton implements Record<String>{
    private static LazySingleton instance;
    private List<Object> list;

    public LazySingleton() {
        list = new ArrayList<>();
    }

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    @Override
    public void add(String s) {
        list.add(s);
    }

    @Override
    public String deleteAndTake(String s) {
        list.remove(s);
        return s;
    }
}
