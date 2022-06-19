package Model.ProductFactory;

import Model.Identifier;

public class Electonic extends Identifier implements IProduct {
    private String name;
    private Double price;
    private String info = "Bilgi yok.";

    public Electonic(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Electonic(String name, double price, String info) {
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
        return "Electonic{" +
                name + ' ' +
                price + ' ' +
                info +
                '}';
    }
}
