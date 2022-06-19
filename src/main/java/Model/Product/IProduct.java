package Model.Product;


public  interface IProduct {
    String getInfo();
    Double getPrice();
    String getName();
    void setName(String name);
    void setPrice(double price);
    void setInfo(String info);


}
