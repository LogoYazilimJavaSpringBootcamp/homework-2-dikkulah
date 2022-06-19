package model.personality_factory;


import model.Order;

import java.util.Date;
import java.util.List;

public interface IPersonality {
    String toStringFullName();

    List<Order> getOrders();

    String getSector();

    String getName();

    Date getJoinDate();
}
