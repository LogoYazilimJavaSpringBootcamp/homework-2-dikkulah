package Model;

import Model.PersonalityFactory.IPersonality;
import Model.PersonalityFactory.Indivudial;
import Model.ProductFactory.IProduct;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
public class Order extends Identifier {

    private final static List<Order> allOrders = new ArrayList<>(); // kayıt görevi görüyor
    private IPersonality iPersonality;
    private List<IProduct> IProducts;
    private Double totalPrice;
    private Date orderDate;

    public Order(IPersonality iPersonality, List<IProduct> IProducts) {
        this.iPersonality = iPersonality;
        this.IProducts = IProducts;
        this.orderDate = new Date();
        this.totalPrice = calcPrice(IProducts);

    }

    public Order(IPersonality iPersonality, List<IProduct> IProducts, Date orderDate) {
        this.iPersonality = iPersonality;
        this.IProducts = IProducts;
        this.totalPrice = calcPrice(IProducts);
        this.orderDate = orderDate;
    }

    public static List<Order> getAllOrders() {
        return allOrders;
    }

    private static Double calcPrice(List<IProduct> IProductList) {
        var price = IProductList.stream().map(IProduct::getPrice).toList();
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
                " | " + IProducts.toString() +
                " | " + totalPrice + "₺ ";
    }


}
