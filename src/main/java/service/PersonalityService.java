package service;

import model.personality_factory.IPersonality;

public interface PersonalityService {
    void save(IPersonality iPersonality); // Kullanıcı kaydetme

    void findByContainsLetter(String letter); // Adında c harfini ierinler

    void printAll(); // Tüm müşterileri yazdırma

    void getSectorFromFiltered(Double price, String month);  // x ayındaki siparişleri ortalaması x değerinden küçük olanları yazdırma
}