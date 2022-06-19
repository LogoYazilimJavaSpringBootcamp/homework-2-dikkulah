package Service;

import Model.PersonalityFactory.IPersonality;
import Model.Order;

import java.util.ArrayList;
import java.util.List;

public class PersonalityImp implements PersonalityService {


    private static final List<IPersonality> ALL_PERSONALITY = new ArrayList<>(); // kayıt görevi görüyor

    @Override
    public void save(IPersonality iPersonality) {

        System.out.println(iPersonality.toStringFullName() + " kaydedildi.");
        ALL_PERSONALITY.add(iPersonality);
    }

    @Override
    public void findByContainsLetter(String letter) {
        System.out.println("|----------  " + letter + " Harfini içerenler----|");
        ALL_PERSONALITY.stream()
                .map(IPersonality::toString)
                .filter(s -> (s.contains(letter.toLowerCase()) || s.contains(letter.toUpperCase())))
                .forEach(System.out::println);
    }


    @Override
    public void printAll() {
        System.out.println("|-------------------------------Tüm Müşteriler-------------------------------| ");
        ALL_PERSONALITY.stream().map(IPersonality::toString).forEach(System.out::println);


    }

    /***
     *
     * @param price average price
     * @param month ingilizce ayın kısaltması
     *
     */
    @Override
    public  void getSectorFromFiltered(Double price, String month) {
        System.out.println("----- "+month+" ayındaki faturalarının ortalamaları "+ price+ "₺ dan küçük olanları sektörleri---");
        for (IPersonality iPersonality :ALL_PERSONALITY) {

                if (!(iPersonality.getOrders().size() ==0)) {
                    if (iPersonality.getOrders().stream().filter(order -> order.getOrderDate().toString().contains(month))
                            .mapToDouble(Order::getTotalPrice).average().orElseThrow() < price) {
                        System.out.println(" " + iPersonality.getSector());
                    }
                }

        }

    }


}


