package singleton;

import java.util.ArrayList;
import java.util.List;

public enum EnumSingleton implements Record<String>{
    INSTANCE;
    private List<Object> list= new ArrayList<>();

    EnumSingleton() {
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
