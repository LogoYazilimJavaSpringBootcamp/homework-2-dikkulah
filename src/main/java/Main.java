import Model.Order;
import Model.PersonalityFactory.IPersonality;
import Model.PersonalityFactory.PersonalityFactory;
import Model.PersonalityFactory.PersonalityType;
import Model.ProductFactory.IProduct;
import Model.ProductFactory.ProductFactory;
import Model.ProductFactory.ProductType;
import Service.PersonalityImp;
import Service.PersonalityService;
import Service.OrderImp;
import Service.OrderService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    static PersonalityService personalityService = new PersonalityImp();
    static OrderService orderService = new OrderImp();


    public static void main(String[] args) {
        ProductFactory productFactory = new ProductFactory();
        IProduct elma = productFactory.ProduceProduct(ProductType.Fruit, "Elma", 50.);
        IProduct karpuz = productFactory.ProduceProduct(ProductType.Fruit, "Karpuz", 50.);
        IProduct telefon = productFactory.ProduceProduct(ProductType.Electronic, "Telefon", 1000.0);
        IProduct et = productFactory.ProduceProduct(ProductType.Meat, "Dana Kıyma", 150.0);

        PersonalityFactory personalityFactory = new PersonalityFactory();
        IPersonality ufuk = personalityFactory.producePersonality(PersonalityType.Indivudial, "Ufuk", "Dikkülah", "Yazılım");
        IPersonality ahmet = personalityFactory.producePersonality(PersonalityType.Indivudial, "Ahmet", "Yılmaz", "Yazılım");
        IPersonality tugce = personalityFactory.producePersonality(PersonalityType.Indivudial, "Tuğçe", "Eren", "Turizm");
        IPersonality zeynep = personalityFactory.producePersonality(PersonalityType.Indivudial, "Zeynep", "Kıran", "Turizm");
        IPersonality ceyhun = personalityFactory.producePersonality(PersonalityType.Indivudial, "Ceyhun", "Melek", "Emlak");
        IPersonality logo = personalityFactory.producePersonality(PersonalityType.Corporate,"Logo",null,"Yazılım");

        List<IProduct> IProductList = new ArrayList<>(5);
        List<IProduct> IProductList1 = new ArrayList<>(5);
        List<IProduct> IProductList3 = new ArrayList<>(5);
        List<IProduct> IProductList2 = new ArrayList<>(5);

        IProductList3.add(karpuz);
        IProductList3.add(elma);
        IProductList3.add(et);

        IProductList2.add(karpuz);
        IProductList2.add(karpuz);
        IProductList2.add(et);
        IProductList2.add(et);
        IProductList2.add(et);
        IProductList2.add(et);
        IProductList2.add(et);

        IProductList.add(telefon);
        IProductList.add(telefon);
        IProductList.add(karpuz);
        IProductList.add(karpuz);

        IProductList1.add(telefon);
        IProductList1.add(telefon);

        personalityService.save(logo);
        personalityService.save(ufuk);
        personalityService.save(ahmet);
        personalityService.save(tugce);
        personalityService.save(ceyhun);
        personalityService.save(zeynep); // Yeni Müşteri kayıt
        Order order6 = new Order(ceyhun, IProductList3, new Date());
        Order order1 = new Order(ufuk, IProductList);
        Order order4 = new Order(ufuk, IProductList1);
        Order order2 = new Order(tugce, IProductList3);
        Order order3 = new Order(ceyhun, IProductList3);
        Order order5 = new Order(tugce, IProductList2);

        orderService.save(tugce, order5);
        orderService.save(ufuk, order4);
        orderService.save(ufuk, order1);
        orderService.save(tugce, order2);
        orderService.save(ceyhun, order3);
        orderService.save(ceyhun, order6);


        System.out.println();
        orderService.printAll();
        System.out.println();
        personalityService.printAll(); //Tüm müşterileri listeleme
        System.out.println();
        orderService.printOrdersByCustomer(ufuk); // müşterinin faturaları
        System.out.println();
        personalityService.findByContainsLetter("C"); // C içeren müşterileri listeleme
        System.out.println();
        orderService.findHigherThenX(1500.0); //1500 den büyük faturalar
        System.out.println();
        orderService.findAverageHigherThenX(1500.0); // 1500 den büyük faturaların ortalamas
        System.out.println();
        orderService.findLowerThenX(500.0); // 500 den küçük faturalar
        System.out.println();
        personalityService.getSectorFromFiltered(750.0,"Jun"); //x ayı faturaları ortalaması x ten küçük olanların sectörleri
        System.out.println();
        orderService.findSumOrderByJoinDate("Jun"); // x ayında kayıt olanların fatura toplamı

    }
}
