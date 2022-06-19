package abstract_factory;

public class Beko extends Company{
    @Override
    public TV createTV() {
        return new BekoTV();
    }

    @Override
    public Freezer createFreezer() {
        return new BekoFreezer();
    }
}
