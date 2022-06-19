package model.product_factory;

public class ProductFactory implements IProductFactory {


    @Override
    public IProduct produceProduct(ProductType type, String name, Double price, String info) {
        return switch (type) {
            case FRUIT -> new Fruit(name, price, info);
            case MEAT -> new Meat(name, price, info);
            case ELECTRONIC -> new Electonic(name, price, info);
        };
    }

    @Override
    public IProduct produceProduct(ProductType type, String name, Double price) {
        return switch (type) {
            case FRUIT -> new Fruit(name, price);
            case MEAT -> new Meat(name, price);
            case ELECTRONIC -> new Electonic(name, price);

        };
    }


}
