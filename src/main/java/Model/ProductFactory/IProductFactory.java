package Model.ProductFactory;

public interface IProductFactory {
    IProduct ProduceProduct(ProductType type, String name, Double price) ;
    IProduct ProduceProduct(ProductType type, String name, Double price, String info);

}
