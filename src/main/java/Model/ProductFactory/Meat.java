package Model.ProductFactory;

import Model.Identifier;

public class Meat extends Identifier implements IProduct {
    private String name;
    private Double price;
    private String info = "Bilgi yok.";


    public Meat(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Meat(String name, double price, String info) {
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
        return "Meat{" +
                name + ' ' +
                price + ' '+
                info + ' ' +
                '}';
    }
}
