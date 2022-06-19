package abstract_factory;

public class VestelFreezer implements Freezer {
    @Override
    public void produceFreezer() {
        System.out.println("Vestel dondurucu üretildi.");

    }
}
