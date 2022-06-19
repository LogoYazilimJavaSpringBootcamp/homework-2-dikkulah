package Model.ProductFactory;

public class ProductFactory implements IProductFactory {


    @Override
    public IProduct ProduceProduct(ProductType type, String name, Double price, String info) {
        return switch (type) {
            case Fruit -> new Fruit(name, price, info);
            case Meat -> new Meat(name, price, info);
            case Electronic -> new Electonic(name, price, info);
        };
    }

    @Override
    public IProduct ProduceProduct(ProductType type, String name, Double price) {
        return switch (type) {
            case Fruit -> new Fruit(name, price);
            case Meat -> new Meat(name, price);
            case Electronic -> new Electonic(name, price);

        };
    }


}
