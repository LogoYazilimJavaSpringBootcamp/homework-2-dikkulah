package model.personality_factory;

import model.Identifier;
import model.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Indivudial extends Identifier implements IPersonality {
    private String name;
    private String surName;

    private final Date joinDate;
    private  List<Order> orders = new ArrayList<>();
    private String sector;




    // tarih ile girmek için
    public Indivudial(String name, String surName, Date joinDate, String sector) {
        this.name = name;
        this.surName = surName;
        this.joinDate = joinDate;
        this.sector = sector;
    }

    public Indivudial(String name, String surName, String sector) {
        this.name = name;
        this.surName = surName;
        this.sector = sector;
        this.joinDate = new Date();

    }

    @Override
    public String toStringFullName() {
        return name+ " "+surName;
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

    @Override
    public String toString() {
        return "Indivudial{" +
                "ID"+super.toString()+
                 name + ' ' +
                surName + ' ' +
                 joinDate + ' '+
                sector + ' ' +
                "} " ;
    }
}
