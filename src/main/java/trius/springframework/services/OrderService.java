package trius.springframework.services;

import org.apache.catalina.User;
import trius.springframework.domain.Order;
import trius.springframework.security.UserAccount;

import java.util.List;

public interface OrderService {

    Order saveOrder(Order order);
    Order getOrderByUser(UserAccount userAccount);
    List<Order> getOrderList();

}
