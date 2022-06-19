package Model.PersonalityFactory;


import Model.Order;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface IPersonality {
    String toStringFullName();

    List<Order> getOrders();

    String getSector();

    String getName();

    Date getJoinDate();
}
