package abstract_factory;

public class BekoTV implements TV {
    @Override
    public void produceTV() {
        System.out.println("Beko televizyon üretildi.");
    }
}
