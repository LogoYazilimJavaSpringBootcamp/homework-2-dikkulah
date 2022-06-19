package singleton;

import java.util.ArrayList;
import java.util.List;

public class EagerSingleton implements Record<String>{

    private static final EagerSingleton instance = new EagerSingleton();
    private  List<Object> list;

    public EagerSingleton() {
        list = new ArrayList<>();
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

    public static EagerSingleton getInstance() {
        return instance;
    }
}
