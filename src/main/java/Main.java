import model.Order;
import model.personality_factory.IPersonality;
import model.personality_factory.PersonalityFactory;
import model.personality_factory.PersonalityType;
import model.product_factory.IProduct;
import model.product_factory.ProductFactory;
import model.product_factory.ProductType;
import service.PersonalityImp;
import service.PersonalityService;
import service.OrderImp;
import service.OrderService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    static PersonalityService personalityService = new PersonalityImp();
    static OrderService orderService = new OrderImp();


    public static void main(String[] args) {
        ProductFactory productFactory = new ProductFactory();
        IProduct elma = productFactory.produceProduct(ProductType.FRUIT, "Elma", 50.);
        IProduct karpuz = productFactory.produceProduct(ProductType.FRUIT, "Karpuz", 50.);
        IProduct telefon = productFactory.produceProduct(ProductType.ELECTRONIC, "Telefon", 1000.0);
        IProduct et = productFactory.produceProduct(ProductType.MEAT, "Dana Kıyma", 150.0);

        PersonalityFactory personalityFactory = new PersonalityFactory();
        IPersonality ufuk = personalityFactory.producePersonality(PersonalityType.INDIVUDIAL, "Ufuk", "Dikkülah", "Yazılım");
        IPersonality ahmet = personalityFactory.producePersonality(PersonalityType.INDIVUDIAL, "Ahmet", "Yılmaz", "Yazılım");
        IPersonality tugce = personalityFactory.producePersonality(PersonalityType.INDIVUDIAL, "Tuğçe", "Eren", "Turizm");
        IPersonality zeynep = personalityFactory.producePersonality(PersonalityType.INDIVUDIAL, "Zeynep", "Kıran", "Turizm");
        IPersonality ceyhun = personalityFactory.producePersonality(PersonalityType.INDIVUDIAL, "Ceyhun", "Melek", "Emlak");
        IPersonality logo = personalityFactory.producePersonality(PersonalityType.CORPORATE,"Logo",null,"Yazılım");

        List<IProduct> iProductList = new ArrayList<>(5);
        List<IProduct> iProductList1 = new ArrayList<>(5);
        List<IProduct> iProductList3 = new ArrayList<>(5);
        List<IProduct> iProductList2 = new ArrayList<>(5);

        iProductList3.add(karpuz);
        iProductList3.add(elma);
        iProductList3.add(et);

        iProductList2.add(karpuz);
        iProductList2.add(karpuz);
        iProductList2.add(et);
        iProductList2.add(et);
        iProductList2.add(et);
        iProductList2.add(et);
        iProductList2.add(et);

        iProductList.add(telefon);
        iProductList.add(telefon);
        iProductList.add(karpuz);
        iProductList.add(karpuz);

        iProductList1.add(telefon);
        iProductList1.add(telefon);

        personalityService.save(logo);
        personalityService.save(ufuk);
        personalityService.save(ahmet);
        personalityService.save(tugce);
        personalityService.save(ceyhun);
        personalityService.save(zeynep); // Yeni Müşteri kayıt
        Order order6 = new Order(ceyhun, iProductList3, new Date());
        Order order1 = new Order(ufuk, iProductList);
        Order order4 = new Order(ufuk, iProductList1);
        Order order2 = new Order(tugce, iProductList3);
        Order order3 = new Order(ceyhun, iProductList3);
        Order order5 = new Order(tugce, iProductList2);

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
