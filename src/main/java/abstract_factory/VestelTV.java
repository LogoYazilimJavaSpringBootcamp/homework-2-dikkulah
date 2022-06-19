package abstract_factory;

public class VestelTV implements TV {
    @Override
    public void produceTV() {
        System.out.println("Vestel televizyon üretildi.");
    }
}
