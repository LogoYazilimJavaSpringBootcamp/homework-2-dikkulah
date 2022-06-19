package model.personality_factory;

import model.Identifier;
import model.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Corporate extends Identifier implements IPersonality {
    private final Date joinDate;
    private String name;
    private List<Order> orders = new ArrayList<>();
    private String sector;



    // tarih ile girmek için
    public Corporate(String name , Date joinDate, String sector) {
        this.name = name;
        this.joinDate = joinDate;
        this.sector = sector;
    }

    public Corporate(String name , String sector) {
        this.name = name;
        this.sector = sector;
        this.joinDate = new Date();

    }




    @Override
    public String toString() {
        return "Corporate{ID"+super.toString() +
                 name + ' ' +
                 joinDate +' '+
                 orders +' '+
                 sector + ' ' +
                "} ";
    }

    @Override
    public String toStringFullName() {
        return name +" ";
    }

    @Override
    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public String getSector() {
        return sector;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Date getJoinDate() {
        return joinDate;
    }
}
