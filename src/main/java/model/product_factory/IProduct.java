package model.product_factory;


public  interface IProduct {
    String getInfo();
    Double getPrice();
    String getName();
    void setName(String name);
    void setPrice(double price);
    void setInfo(String info);


}
