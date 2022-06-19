package model.product_factory;


import model.Identifier;

public class Fruit extends Identifier implements IProduct {

    private String name;
    private Double price;
    private String info;



    public Fruit(String name, double price) {
        this.name = name;
        this.price = price;
        this.info = "Bilgi yok.";

    }
    public Fruit(String name, double price, String info) {
        this.name = name;
        this.price = price;
        this.info = info;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public void setInfo(String info) {
        this.info = info;
    }


    @Override
    public String toString() {
        return "Fruit{" +
                name + ' ' +
                price + ' '+
                info + ' ' +
                '}';
    }
}
