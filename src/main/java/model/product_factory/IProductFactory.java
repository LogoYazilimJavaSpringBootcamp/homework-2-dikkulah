package model.product_factory;

public interface IProductFactory {
    IProduct produceProduct(ProductType type, String name, Double price) ;
    IProduct produceProduct(ProductType type, String name, Double price, String info);

}
