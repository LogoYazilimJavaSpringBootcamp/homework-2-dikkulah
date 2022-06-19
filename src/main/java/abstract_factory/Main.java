package abstract_factory;

public class Main {
    public static void main(String[] args) {
        Company beko = new Beko();
        TV bekoTV = beko.createTV();
        Freezer bekoFreezer = beko.createFreezer();
        bekoFreezer.produceFreezer();
        bekoTV.produceTV();


        Company vestel = new Vestel();
        TV vestelTV = vestel.createTV();
        Freezer vestelFreezer = vestel.createFreezer();
        vestelTV.produceTV();
        vestelFreezer.produceFreezer();

    }
}
