package Service;

import Model.Customer;
import Model.Order;
import Model.Product.IProduct;

import java.util.*;
import java.util.stream.Collectors;

public class OrderImp implements OrderService {


    @Override
    public void save(Customer customer, Order order) {
        customer.getOrders().add(order);
        System.out.println(customer.getName() + " müşterisine fatura kaydedildi: " + customer.getOrders().get(customer.getOrders().size()-1));
        Order.getAllOrders().add(order);
    }

    @Override
    public void printAll() {
        System.out.println("|---------------------Tüm faturalar-----------------------| ");
        Order.getAllOrders().stream()
                .map(Order::toString)
                .forEach(System.out::println);

    }

    @Override
    public void printOrdersByCustomer(Customer customer) {
        System.out.println("|-------" + customer.toStringFullName() + " ın faturaları : --------------]");
        // Map kullanmak için silindi
        //customer.getOrders().stream().map(order -> order.getId() + " " + order.getIProducts().toString() + " " + order.getTotalPrice() + "₺").forEach(System.out::println);

        Map<String,List<IProduct>> a= Order.getAllOrders().stream().filter(order -> order.getCustomer() == customer).collect(Collectors.toMap(Order::getId, Order::getIProducts));

        a.forEach((key, value) -> System.out.println(key + " " + new ArrayList<>(value) ));
    }


    @Override  // X ayında kayıt olanların fatura toplam tutarı
    public void findSumOrderByJoinDate(String month) {
        List<Order> monthOrders= Order.getAllOrders().stream().filter(order -> order.getCustomer().getJoinDate().toString().contains("Jun")).toList();
        System.out.println("|---"+month + "   ayında kayıt olan müşterilerin fatura toplamı----------|");
        System.out.println(monthOrders.stream().mapToDouble(Order::getTotalPrice).sum());


    }

    @Override
    public void findHigherThenX(Double price) {
        System.out.println("|--------------" + price + "₺ den büyük faturalar----------------| ");
        Order.getAllOrders().stream().filter(order -> order.getTotalPrice() >= price)
                .toList()
                .forEach(System.out::println);
    }

    @Override
    public void findAverageHigherThenX(Double price) {
        System.out.println(price + " ₺ den büyük olan faturaların ortalaması:  "
                + Order.getAllOrders().stream().filter(order -> order.getTotalPrice() >= price)
                .mapToDouble(Order::getTotalPrice).average().orElseThrow() + " ₺");
    }

    @Override
    public void findLowerThenX(Double price) {
        System.out.println("|--------------" + price + "₺ den küçük faturaların sahipleri----------------| ");
        Set<String> setName = new HashSet<>(Order.getAllOrders().stream()
                .filter(order -> order.getTotalPrice() <= price)
                .map(order -> order.getCustomer().toStringFullName())
                .toList());
        setName.forEach(System.out::println);

    }



}
