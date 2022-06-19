package singleton;

public interface Record<O> {
    void add(O o);
    O deleteAndTake(O o);
}
