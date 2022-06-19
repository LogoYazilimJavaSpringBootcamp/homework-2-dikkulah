package service;

import model.Order;
import model.personality_factory.IPersonality;
import model.product_factory.IProduct;

import java.util.*;
import java.util.stream.Collectors;

public class OrderImp implements OrderService {


    @Override
    public void save(IPersonality iPersonality, Order order) {
        iPersonality.getOrders().add(order);
        System.out.println(iPersonality.getName() + "'nin faturası kaydedildi: " + iPersonality.getOrders().get(iPersonality.getOrders().size()-1));
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
    public void printOrdersByCustomer(IPersonality iPersonality) {
        System.out.println("|-------" + iPersonality.toStringFullName() + " ın faturaları : --------------]");

        Map<String,List<IProduct>> a= Order.getAllOrders().stream().filter(order -> order.getIPersonality() == iPersonality).collect(Collectors.toMap(Order::getId, Order::getIProducts));

        a.forEach((key, value) -> System.out.println(key + " " + new ArrayList<>(value) ));
    }


    @Override  // X ayında kayıt olanların fatura toplam tutarı
    public void findSumOrderByJoinDate(String month) {
        List<Order> monthOrders= Order.getAllOrders().stream().filter(order -> order.getIPersonality().getJoinDate().toString().contains("Jun")).toList();
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
                .map(order -> order.getIPersonality().toStringFullName())
                .toList());
        setName.forEach(System.out::println);

    }



}
