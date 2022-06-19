package model;

import lombok.Getter;
import lombok.Setter;
import model.personality_factory.IPersonality;
import model.product_factory.IProduct;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
public class Order extends Identifier {

    private static final List<Order> allOrders = new ArrayList<>(); // kayıt görevi görüyor
    private IPersonality iPersonality;
    private List<IProduct> iProducts;
    private Double totalPrice;
    private Date orderDate;

    public Order(IPersonality iPersonality, List<IProduct> iProducts) {
        this.iPersonality = iPersonality;
        this.iProducts = iProducts;
        this.orderDate = new Date();
        this.totalPrice = calcPrice(iProducts);

    }

    public Order(IPersonality iPersonality, List<IProduct> iProducts, Date orderDate) {
        this.iPersonality = iPersonality;
        this.iProducts = iProducts;
        this.totalPrice = calcPrice(iProducts);
        this.orderDate = orderDate;
    }

    public static List<Order> getAllOrders() {
        return allOrders;
    }

    private static Double calcPrice(List<IProduct> iProducts) {
        var price = iProducts.stream().map(IProduct::getPrice).toList();
        double sum = 0;
        for (Double value : price) {
            sum += value;
        }
        return sum;
    }


    @Override
    public String toString() {
        return "OrderId:" + super.toString() +
                " | " + iPersonality.toStringFullName() +
                " | " + iProducts.toString() +
                " | " + totalPrice + "₺ ";
    }


}
