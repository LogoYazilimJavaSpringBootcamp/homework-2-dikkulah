package abstract_factory;

public class Vestel extends Company{
    @Override
    public TV createTV() {
        return new VestelTV();
    }

    @Override
    public Freezer createFreezer() {
        return new VestelFreezer();
    }
}
